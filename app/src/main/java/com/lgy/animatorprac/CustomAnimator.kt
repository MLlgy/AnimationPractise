package com.lgy.animatorprac

import android.animation.Animator
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.view.animation.Animation
import android.view.animation.Transformation

/**
 * Author: GY.LEE
 * Date: 2019/2/19
 */

open class CustomAnimator:Animation(){



    override fun initialize(width: Int, height: Int, parentWidth: Int, parentHeight: Int) {
        super.initialize(width, height, parentWidth, parentHeight)
    }


    override fun applyTransformation(interpolatedTime: Float, t: Transformation?) {
        super.applyTransformation(interpolatedTime, t)
    }



}