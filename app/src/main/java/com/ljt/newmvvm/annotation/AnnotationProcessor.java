package com.ljt.newmvvm.annotation;

/**
 * Filed 注解处理器
 */
public class AnnotationProcessor {

    /**
     * 真正的注解使用方式，将注解的值注入到对象的成员变量或方法中
     * @param target
     */
    public static void init(AnnotationTarget target){
        Class pClass = target.getClass();

        //获取所有的成员变量
        java.lang.reflect.Field[] fields = pClass.getDeclaredFields();
        //获取someFunction()方法
//        Method method = pClass.getDeclaredMethod("someFunction",String.class,int.class);

        //遍历获取被@Field注解的
        for (java.lang.reflect.Field field: fields){
            if (field.isAnnotationPresent(Field.class)){

                //获取注解中的值
                Field name = field.getAnnotation(Field.class);
                String value = name.value();

                // 值为 true 指示反射的对象应该忽略Java语言访问检查，即可以访问Private修饰的属性和方法；
                // 值为 false 指示反射的对象应该执行Java语言访问检查，即不能访问Private修饰的属性和方法。
                field.setAccessible(false);
                try {

                    //将值value设置到类target中
                    field.set(target,value);
                    //将两个参数注入方法someFunction(《参数1》,《参数2》)
                    //method.invoke(target,"参数1",10086);

                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
