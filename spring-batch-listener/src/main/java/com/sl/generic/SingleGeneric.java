package com.sl.generic;

import com.sl.generic.UnaryFunction;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shuliangzhao
 * @Title: SingleGeneric
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2020/8/2 17:29
 */
public class SingleGeneric {

    /**
     * 返回未被修改的参数arg
     */
    private static UnaryFunction<Object> IDENTITY_FUNCTION = (Object arg) -> {
        return arg;
    };

    /**
     * 泛型方法identityFunction：
     *      返回类型：UnaryFunction<T>
     *      类型参数列表；<T>
     * 忽略强制转换未受检查的警告：
     * 因为返回未被修改的参数arg，所以我们知道无论T的值是什么，都是类型安全的
     * @param <T>
     * @return
     */
    @SuppressWarnings("unchacked")
    public static <T> UnaryFunction<T> identityFunction(){
        return (UnaryFunction<T>) IDENTITY_FUNCTION;
    }

    public static void main(String[] args) {
        String[] strings = {"hello","world"};
        UnaryFunction<String> sameString = identityFunction();
        for (String s: strings) {
            System.out.println(sameString.apply(s));
        }
        Number[] numbers = {1,2.0};
        UnaryFunction<Number> sameNumber = identityFunction();
        for (Number n: numbers) {
            System.out.println(sameNumber.apply(n));
        }


        Number n = 1.0;
        Integer i = 1;
        Double d = 1.0;
        List<? extends Number> list= new ArrayList<>();
        list= new ArrayList<Number>();
        list= new ArrayList<Integer>();
        list= new ArrayList<Double>();
        //list.add(i);





        
    }
}
