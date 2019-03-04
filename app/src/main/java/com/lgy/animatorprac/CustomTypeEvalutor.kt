package com.lgy.animatorprac

import android.animation.TypeEvaluator
import android.util.Log

/**
 * Author: GY.LEE
 * Date: 2019/3/3
 */
class CustomTypeEvalutor : TypeEvaluator<Int> {
    override fun evaluate(fraction: Float, startValue: Int, endValue: Int): Int {

        Log.e("Fraction TypeEvaluator", fraction.toString())
        val value = (startValue + (endValue - startValue) * fraction).toInt()
        Log.e("Evalutor TypeEvaluator", value.toString())
        return value
    }
}