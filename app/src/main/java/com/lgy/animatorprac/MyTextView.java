package com.lgy.animatorprac;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

/**
 * Author: GY.LEE
 * Date: 2019/3/4
 */
public class MyTextView extends AppCompatTextView {
    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setCharText(Character charText) {
        setText(String.valueOf(charText));
    }
}
