package com.ljt.newmvvm.ui

fun main(args: Array<String>) {
    val b = Array(3,{
        it*2
    })

    b.forEach {
        print("$it,")
    }
}