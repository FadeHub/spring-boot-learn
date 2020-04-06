package com.sl.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.Arrays;

/**
 * @author shuliangzhao
 * @Title: TestReflect
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2020/4/5 16:07
 */
public class TestReflect {

    public static void main(String[] args) throws Exception {
        Class class1 = Person.class;
        //判断是否是基础类型
        boolean isPrimitive = class1.isPrimitive();
        System.out.println("是否是基础类型：" + isPrimitive);
        //判断是否是集合类
        boolean isArray = class1.isArray();
        System.out.println("是否是集合类："+isArray);
        //判断是否是注解类
        boolean isAnnotation = class1.isAnnotation();
        System.out.println("是否是注解类：" + isAnnotation);
        //判断是否是接口类
        boolean isInterface = class1.isInterface();
        System.out.println("是否是接口类：" + isInterface);
        //判断是否是枚举类
        boolean isEnum = class1.isEnum();
        System.out.println("是否是枚举类：" + isEnum);
        //判断是否是匿名内部类
        boolean isAnonymousClass = class1.isAnonymousClass();
        System.out.println("是否是匿名内部类：" + isAnonymousClass);
        //判断是否被某个注解类修饰
        boolean isAnnotationPresent = class1.isAnnotationPresent(Deprecated.class);
        System.out.println("是否被某个注解类修饰：" +isAnnotationPresent);
        //获取class名字 包含包名路径
        String className = class1.getName();
        System.out.println("获取class名字 包含包名路径：" +className);
        //获取class的包信息
        Package aPackage = class1.getPackage();
        System.out.println("获取class的包信息：" + aPackage);
        //获取class类名
        String simpleName = class1.getSimpleName();
        System.out.println("获取class类名：" + simpleName);
        //获取class访问权限
        int modifiers = class1.getModifiers();
        System.out.println("获取class访问权限：" + modifiers);
        //内部类
        Class<?>[] declaredClasses = class1.getDeclaredClasses();
        System.out.println("内部类：" + declaredClasses);
        //外部类
        Class<?> declaringClass = class1.getDeclaringClass();
        System.out.println("外部类：" +declaringClass );

        Field[] fields = class1.getFields();
        Field[] declaredFields = class1.getDeclaredFields();
        Person person = new Person();
        person.setName("张三");
        Field field = person.getClass().getDeclaredField("name");
        field.setAccessible(true);
        field.set(person,"李四");
        System.out.println(person.getName());

        Method[] methods = class1.getMethods();
        Method[] declaredMethods = class1.getDeclaredMethods();
        System.out.println(Arrays.toString(methods));
        System.out.println("+++++++++++++++");
        System.out.println(Arrays.toString(declaredMethods));
        Class[] str = {String.class};
        Method setName = class1.getDeclaredMethod("setCardId", str);
        setName.setAccessible(true);
        setName.invoke(person,"123333333");

        Constructor[] constructors = class1.getConstructors();
        System.out.println(Arrays.toString(constructors));
        Constructor[] declaredConstructors = class1.getDeclaredConstructors();
        System.out.println(Arrays.toString(declaredConstructors));
        Class[] clz = {String.class,int.class};
        Constructor declaredConstructor = class1.getDeclaredConstructor(clz);
        Person person1 = (Person) declaredConstructor.newInstance("赵云", 25);
        System.out.println(person1.getName() + ":" + person1.getAge());

        Annotation[] annotations = class1.getAnnotations();
        System.out.println(Arrays.toString(annotations));

        Type type = class1.getGenericSuperclass();
        Type[] genericInterfaces = class1.getGenericInterfaces();
        Class<?> componentType = null;
        String typeName = type.getTypeName();
        if (type instanceof ParameterizedType) {
            Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
            if (actualTypeArguments != null && actualTypeArguments.length > 0) {
                componentType = (Class<?>) actualTypeArguments[0];
            }
        }  else if (type instanceof GenericArrayType) {
            // 表示一种元素类型是参数化类型或者类型变量的数组类型
            componentType = (Class<?>) ((GenericArrayType) type).getGenericComponentType();
        }else {
            componentType = (Class<?>) type;
        }
        System.out.println(type);


    }
}
