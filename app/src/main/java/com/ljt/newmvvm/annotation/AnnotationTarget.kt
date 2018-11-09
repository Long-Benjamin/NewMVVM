package com.ljt.newmvvm.annotation

/**
 * 初始化调用注解解析器
 */
class AnnotationTarget{

    @Field(value = "name默认为0000，现在是这句话！")
    private var name: String? = null


    constructor(){
        //初始化注解处理器
        AnnotationProcessor.init(this)

    }


    fun showName(){
        //输出成员变量值
        print(name)

    }



}