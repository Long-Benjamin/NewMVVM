package com.ljt.mvvmdemo.utilities.glides

import com.bumptech.glide.annotation.GlideExtension
import com.bumptech.glide.annotation.GlideOption
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import android.R.transition
import com.bumptech.glide.load.resource.gif.GifDrawable
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.annotation.GlideType
import com.bumptech.glide.request.RequestOptions.decodeTypeOf

/**
 * ！注意：
 *  1.MyAppExtension需要使用私有的构造函数
 *  2.可以使用静态变量，用const 关键字来修饰
 *  3.自定义的方法必须是静态方法
 */
@GlideExtension
open class MyAppExtension private constructor() {

    companion object {

        const val MINI_THUMB_SIZE = 100
        private val DECODE_TYPE_GIF = decodeTypeOf(GifDrawable::class.java).lock()

        /**
         * 自定方法实现，可直接GlideApp链式结构中使用【屌的飞起】
         */
        @GlideOption
        @JvmStatic fun miniThumb(options: RequestOptions){
            options.fitCenter().override(MINI_THUMB_SIZE);
        }

        @GlideType(GifDrawable::class)
        @JvmStatic fun asAGif(requestBuilder: RequestBuilder<GifDrawable>) {
            requestBuilder
                    .transition(DrawableTransitionOptions())
                    .apply(DECODE_TYPE_GIF)
        }

    }

}