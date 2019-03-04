package com.lgy.animatorprac.event;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Author: GY.LEE
 * Date: 2019/3/1
 */
public class ViewGroupA extends LinearLayout {
    int rw;
    int rh;

    private static final String TAG = "ViewGroupA";

    public ViewGroupA(Context context) {
        super(context);
    }

    public ViewGroupA(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ViewGroupA(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        rw = MeasureSpec.getSize(widthMeasureSpec);
        rh = MeasureSpec.getSize(heightMeasureSpec);
        setMeasuredDimension(rw, rh);
    }


    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int childCount = this.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = this.getChildAt(i);
            child.layout(rw / 3, rh / 3, rw / 2 + 600, rh / 2 + 600);

//            LinearLayout.LayoutParams lParams = (LayoutParams) child.getLayoutParams();
//            Log.e(TAG, "onLayout: " + lParams.leftMargin + "  " + lParams.topMargin);
//            child.layout(lParams.leftMargin, lParams.topMargin, lParams.leftMargin + rw,
//                    lParams.topMargin + rh);

        }
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
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.e(TAG, "onInterceptTouchEvent: " + super.onInterceptTouchEvent(ev));
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.e(TAG, "onInterceptTouchEvent: MotionEvent.ACTION_DOWN");

                break;
            case MotionEvent.ACTION_MOVE:

                Log.e(TAG, "onInterceptTouchEvent: MotionEvent.ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.e(TAG, "onInterceptTouchEvent: MotionEvent.ACTION_UP");

                break;
            default:
                break;
        }
        return super.onInterceptTouchEvent(ev);
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
