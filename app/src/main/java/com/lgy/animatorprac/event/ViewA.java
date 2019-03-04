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
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e(TAG, "dispatchTouchEvent: " + super.dispatchTouchEvent(ev));
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.e(TAG, "dispatchTouchEvent: MotionEvent.ACTION_DOWN");

                break;
            case MotionEvent.ACTION_MOVE:

                Log.e(TAG, "dispatchTouchEvent: MotionEvent.ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.e(TAG, "dispatchTouchEvent: MotionEvent.ACTION_UP");

                break;
            default:
                break;
        }
        return super.dispatchTouchEvent(ev);
    }



    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e(TAG, "onTouchEvent: " + super.onTouchEvent(event));
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.e(TAG, "onTouchEvent: MotionEvent.ACTION_DOWN");

                break;
            case MotionEvent.ACTION_MOVE:

                Log.e(TAG, "onTouchEvent: MotionEvent.ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.e(TAG, "onTouchEvent: MotionEvent.ACTION_UP");

                break;
            default:
                break;
        }
        return super.onTouchEvent(event);
    }
}
