package com.sl.anno;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @package: com.sl.anno
 * @author: shuliangzhao
 * @description:
 * @date 2026/2/9 14:19
 */
public class MapAnnotationAssembler {

    private static final Map<Class<?>,Map<Field,MapField>> META_CACHE = new ConcurrentHashMap();


    public static <T> Map<String ,Object> assemble(T obj) {
        if(obj == null) {
            throw new IllegalArgumentException("实体对象不能为null");
        }
        Class<?> cls = obj.getClass();
        // 校验是否加了MapMapping注解
        if (!cls.isAnnotationPresent(MapMapping.class)) {
            throw new IllegalArgumentException(cls.getName() + "未添加@MapMapping注解，无法映射");
        }

        Map<String, Object> resultMap = new HashMap<>();
        // 从缓存获取元数据，无则解析并放入缓存
        Map<Field, MapField> fieldAnnoMap = META_CACHE.computeIfAbsent(cls, MapAnnotationAssembler::parseFieldAnno);

        // 遍历属性，按注解规则put到Map
        for (Map.Entry<Field, MapField> entry : fieldAnnoMap.entrySet()) {
            Field field = entry.getKey();
            MapField mapField = entry.getValue();
            try {
                field.setAccessible(true); // 突破私有属性访问限制
                Object value = field.get(obj);
                // 空值过滤（可根据业务注释，保留空值）
                if (value == null) {
                    continue;
                }
                // 取注解的key，无则用属性名
                String mapKey = mapField.key().isEmpty() ? field.getName() : mapField.key();
                resultMap.put(mapKey, value);
            } catch (IllegalAccessException e) {
                throw new RuntimeException("属性映射失败：" + field.getName(), e);
            }
        }
        return resultMap;
    }

    /**
     * 解析类的属性和对应的@MapField注解，过滤掉ignore=true的属性
     */
    private static Map<Field, MapField> parseFieldAnno(Class<?> cls) {
        Map<Field, MapField> fieldAnnoMap = new HashMap<>();
        Field[] fields = cls.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(MapField.class)) {
                MapField mapField = field.getAnnotation(MapField.class);
                // 忽略标记为ignore=true的属性
                if (!mapField.ignore()) {
                    fieldAnnoMap.put(field, mapField);
                }
            }
        }
        return fieldAnnoMap;
    }

    // 重载方法：将属性映射到**已有Map**（适合需要追加属性的场景）
    public static <T> void assembleToMap(T obj, Map<String, Object> targetMap) {
        if (targetMap == null) {
            targetMap = new HashMap<>();
        }
        targetMap.putAll(assemble(obj));
    }
}
