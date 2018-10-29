package com.ljt.newmvvm.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 注解解析器
 */
public class AnnotationProcessor {

    /**
     * 真正的注解使用方式，将注解的值注入到对象的成员变量或方法中
     * @param ktCase
     */
    public static void init(KTCase ktCase){
        Class pClass = ktCase.getClass();
        //获取所有的成员变量
        Field[] fields = pClass.getDeclaredFields();
        //获取someFunction()方法
//        Method method = pClass.getDeclaredMethod("someFunction",String.class,int.class);
        for (Field field: fields){
            if (field.isAnnotationPresent(Case.class)){
                Case name = field.getAnnotation(Case.class);
                String x = name.value();
                field.setAccessible(true);
                try {
                    field.set(ktCase,x);
                    //将两个参数注入方法someFunction("注解到方法",10086)
//                    method.invoke(ktCase,"注解到方法",10086);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
