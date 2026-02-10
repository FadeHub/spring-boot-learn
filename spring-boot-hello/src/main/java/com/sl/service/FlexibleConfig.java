package com.sl.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @package: com.sl.service
 * @author: shuliangzhao
 * @description:
 * @date 2026/2/10 10:04
 */
public class FlexibleConfig {

    // 存储基础配置
    private static final Properties BASE_CONFIG = new Properties();
    // 存储别名映射（aliasKey -> baseKey）
    private static final Properties ALIAS_CONFIG = new Properties();
    // 配置文件路径
    private static final String CONFIG_PATH = "application.properties";

    // 静态初始化块：加载配置文件
    static {
        try (InputStream input = FlexibleConfig.class.getClassLoader().getResourceAsStream(CONFIG_PATH)) {
            if (input == null) {
                throw new RuntimeException("配置文件 " + CONFIG_PATH + " 未找到");
            }
            // 加载所有配置
            Properties allConfig = new Properties();
            allConfig.load(input);

            // 分离基础配置和别名配置
            for (String key : allConfig.stringPropertyNames()) {
                if (key.startsWith("alias.")) {
                    // 别名配置：去掉前缀后作为aliasKey，值为基础key
                    String aliasKey = key.substring("alias.".length());
                    ALIAS_CONFIG.setProperty(aliasKey, allConfig.getProperty(key));
                } else {
                    // 基础配置直接存储
                    BASE_CONFIG.setProperty(key, allConfig.getProperty(key));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("加载配置文件失败", e);
        }
    }

    /**
     * 核心取值方法：支持别名，多个key对应同一个value
     *
     * @param key 传入的key（可以是基础key或别名key）
     * @return 对应的value
     */
    public static String getValue(String key) {
        // 1. 先检查是否是别名，如果是则转换为基础key
        String realKey = ALIAS_CONFIG.getProperty(key, key);
        // 2. 从基础配置中取值
        String value = BASE_CONFIG.getProperty(realKey);

        // 3. 空值处理（可选，根据业务需求调整）
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("配置项 " + key + " 不存在或值为空");
        }
        return value.trim();
    }

    /**
     * 重载方法：支持默认值
     */
    public static String getValue(String key, String defaultValue) {
        String realKey = ALIAS_CONFIG.getProperty(key, key);
        String value = BASE_CONFIG.getProperty(realKey);
        return (value == null || value.trim().isEmpty()) ? defaultValue : value.trim();
    }


    public static void main(String[] args) {
        // 测试基础key
        System.out.println(getValue("app.name")); // 输出：MyJavaApp
        // 测试别名key（多个别名指向同一个value）
        System.out.println(getValue("dbAddress")); // 输出：jdbc:mysql://localhost:3306/mydb
        System.out.println(getValue("databaseUrl")); // 输出：jdbc:mysql://localhost:3306/mydb
        // 测试默认值
        System.out.println(getValue("unknown.key", "default")); // 输出：default
    }
}
