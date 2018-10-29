package com.ljt.newmvvm.annotation

/**
 * 初始化调用注解解析器
 */
class KTCase{

    @Case(value = "这里的值会替换掉默认值000")
    private var name: String? = null

    constructor(){
        AnnotationProcessor.init(this)//调用注解解析器
    }

    fun showName(){
        print(name)
    }



}