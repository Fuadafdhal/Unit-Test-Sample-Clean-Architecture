package com.afdhal_fa.unittestsample.movie.util

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions

/**
 * Created by Muh Fuad Afdhal on 9/27/2021
 * Email: fuad.afdal.fa@gmail.com
 */

fun ImageView.loadImage(imageUrl: String) {
    if (imageUrl.isEmpty()) return
    Glide.with(this.context)
        .load(imageUrl.createImageUrl())
        .transition(DrawableTransitionOptions.withCrossFade())
        .thumbnail(MovieConstant.GLIDE_THUMBNAIL_SIZE_MULTIPLIER)
        .apply(RequestOptions.fitCenterTransform())
        .into(this)
}