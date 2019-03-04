package com.lgy.animatorprac.valurAnimatorOfObject

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import android.view.animation.BounceInterpolator

/**
 * Author: GY.LEE
 * Date: 2019/3/3
 */
class PointView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    var point: Point? = null
    val paint by lazy {
        Paint()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        if (point != null) {
            paint.isAntiAlias = true
            paint.color = Color.RED
            paint.style = Paint.Style.FILL
            canvas?.drawCircle(300f, 300f, point?.radius!!.toFloat(), paint)
        }


    }

    fun doAnimator() {
        val valueAnimator = ValueAnimator.ofObject(PointEvaluator(), Point(20), Point(100))
        valueAnimator.addUpdateListener { animation ->
            point = animation.animatedValue as Point
            invalidate()
        }

        valueAnimator.duration = 1000
        valueAnimator.interpolator = BounceInterpolator()
        valueAnimator.start()

    }
}