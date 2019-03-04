package com.lgy.animatorprac

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView

/**
 * Author: GY.LEE
 * Date: 2019/3/4
 */
class MyTextViewTwo(context: Context, attributeSet: AttributeSet) : TextView(context, attributeSet) {

    fun setCharText(charText: Char) {
        text = charText.toString()
    }

}