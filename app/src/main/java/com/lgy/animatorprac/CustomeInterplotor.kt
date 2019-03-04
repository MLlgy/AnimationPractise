package com.lgy.animatorprac

import android.animation.TimeInterpolator
import android.util.Log

/**
 * Author: GY.LEE
 * Date: 2019/3/3
 */
class CustomeInterplotor : TimeInterpolator {
    override fun getInterpolation(input: Float): Float {
        val fraction = 1- input
        Log.e("Fraction TimeInterpolator", fraction.toString())
        return fraction
    }
}