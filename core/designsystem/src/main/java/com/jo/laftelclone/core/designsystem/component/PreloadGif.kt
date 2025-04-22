package com.jo.laftelclone.core.designsystem.component

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.Log
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.gif.GifDrawable
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.jo.laftelclone.core.designsystem.R

object PreloadGif {
    var resource: GifDrawable? = null
    fun preloadGif(context: Context) {
        Glide.with(context)
            .asGif()
            .load(R.drawable.bg_login)
            .listener(object : RequestListener<GifDrawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<GifDrawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    Log.e("Glide", "Image load failed: ${e?.message}")
                    return false // 로딩 실패시 기본 처리
                }

                override fun onResourceReady(
                    resource: GifDrawable?,
                    model: Any?,
                    target: Target<GifDrawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    if(this@PreloadGif.resource == null) {
                        this@PreloadGif.resource = resource
                    }
                    Log.d("Glide", "Image loaded successfully")
                    return false // 이미지 로딩 완료 시 기본 처리
                }
            })
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .preload()
    }
}