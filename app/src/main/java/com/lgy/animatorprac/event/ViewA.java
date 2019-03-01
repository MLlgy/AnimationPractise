package com.lgy.animatorprac.event;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

/**
 * Author: GY.LEE
 * Date: 2019/3/1
 */
public class ViewA extends android.view.View {

    private static final String TAG = "ViewA";

    public ViewA(Context context) {
        super(context);
    }

    public ViewA(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ViewA(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.e(TAG, "dispatchTouchEvent: " + super.dispatchTouchEvent(event));
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e(TAG, "onTouchEvent: " + super.onTouchEvent(event));
        return super.onTouchEvent(event);
    }
}
