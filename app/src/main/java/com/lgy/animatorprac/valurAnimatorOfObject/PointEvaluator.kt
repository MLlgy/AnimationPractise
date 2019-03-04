package com.lgy.animatorprac.valurAnimatorOfObject

import android.animation.TypeEvaluator

/**
 * Author: GY.LEE
 * Date: 2019/3/4
 */
class PointEvaluator : TypeEvaluator<Point> {
    override fun evaluate(fraction: Float, startValue: Point?, endValue: Point?): Point {
        val start = startValue?.radius
        val end = endValue?.radius
        val current = start!! + fraction * (end!! - start)
        return Point(current.toInt())

    }
}