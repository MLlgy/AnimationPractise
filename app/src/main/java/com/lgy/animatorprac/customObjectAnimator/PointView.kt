package com.lgy.animatorprac.customObjectAnimator

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.lgy.animatorprac.valurAnimatorOfObject.Point

/**
 * Author: GY.LEE
 * Date: 2019/3/3
 */
class PointView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    val point by lazy {
        Point(100)
    }
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

    fun setPointRadius(radius: Int) {
        point.radius = radius
        invalidate()
    }
}