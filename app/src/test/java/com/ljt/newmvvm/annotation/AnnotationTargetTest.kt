package com.ljt.newmvvm.annotation

import org.junit.Before
import org.junit.Test

class AnnotationTargetTest {

    private lateinit var at: AnnotationTarget

    @Before
    public fun setUp(){
        at = AnnotationTarget()
    }

    @Test
    fun showName() {
        at.showName()
    }
}