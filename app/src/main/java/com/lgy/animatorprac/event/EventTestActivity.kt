package com.lgy.animatorprac.event

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import com.lgy.animatorprac.R

class EventTestActivity : Activity() {

    companion object {
        val TAG = "EventTestActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_test)
    }


    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        Log.e(TAG, "dispatchTouchEvent " + super.dispatchTouchEvent(ev))
        when (ev?.action) {
            MotionEvent.ACTION_DOWN -> Log.e(TAG, "ACTION_DOWN")
            MotionEvent.ACTION_MOVE -> Log.e(TAG, "ACTION_MOVE")
            MotionEvent.ACTION_UP -> Log.e(TAG, "ACTION_UP")
        }
        return super.dispatchTouchEvent(ev)
    }

//    fun onInterceptTouchEvent

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        Log.e(TAG, "onTouchEvent " + super.onTouchEvent(event));
        when (event?.action) {
            MotionEvent.ACTION_DOWN -> Log.e(TAG, "ACTION_DOWN")
            MotionEvent.ACTION_MOVE -> Log.e(TAG, "ACTION_MOVE")
            MotionEvent.ACTION_UP -> Log.e(TAG, "ACTION_UP")
        }
        return super.onTouchEvent(event)
    }
}
