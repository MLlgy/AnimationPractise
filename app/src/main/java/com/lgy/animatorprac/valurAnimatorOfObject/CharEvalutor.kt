package com.lgy.animatorprac.valurAnimatorOfObject

import android.animation.TypeEvaluator

/**
 * Author: GY.LEE
 * Date: 2019/3/3
 */
class CharEvalutor : TypeEvaluator<Char> {
    override fun evaluate(fraction: Float, startValue: Char?, endValue: Char?): Char {
        val start = startValue?.toInt()
        val end = endValue?.toInt()
        val current = (start!! + fraction * (end!! - start)).toInt()
        val result = current.toChar()
        return result
    }
}