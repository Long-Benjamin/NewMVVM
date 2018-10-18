package com.ljt.newmvvm.base.http.entity

import java.util.*

data class MeizhiBean (
        var url: String,
        var type: String?,
        var desc: String?,
        var who: String? ,
        var used: Boolean,
        var createdAt: Date?,
        var updatedAt: Date?,
        var publishedAt: Date?,
        var imageWidth: Int = 0,
        var imageHeight: Int = 0
    ){

    override fun toString(): String {
        return super.toString()
    }
}