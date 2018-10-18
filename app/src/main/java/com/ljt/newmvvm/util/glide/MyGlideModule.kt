package com.ljt.mvvmdemo.utilities.glides

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.Registry
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule
import com.bumptech.glide.load.engine.cache.LruResourceCache



/**
 * 继承这个类之后编译一下，就可以使用GlideApp这个类来加载图片了。
 * GlideApp和Glide的区别：
 *    1.GlideAppn可以使用以前的写法，直接+.placeholder()/.fitCenter()等；
 *    2.现在的Glide需要使用.apply(options)，将.placeholder()/.fitCenter()等放到options中
 */
@GlideModule
class MyGlideModule : AppGlideModule() {

    override fun isManifestParsingEnabled(): Boolean {
        return super.isManifestParsingEnabled()
    }

    override fun applyOptions(context: Context, builder: GlideBuilder) {
        val memoryCacheSizeBytes = 1024 * 1024 * 20 // 20mb
        builder.setMemoryCache(LruResourceCache(memoryCacheSizeBytes.toLong()))
    }

    override fun registerComponents(context: Context, glide: Glide, registry: Registry) {
        super.registerComponents(context, glide, registry)
    }
}