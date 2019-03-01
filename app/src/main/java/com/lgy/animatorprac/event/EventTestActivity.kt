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
        Log.e(TAG, "dispatchTouchEvent" + super.dispatchTouchEvent(ev))
        return super.dispatchTouchEvent(ev)
    }

//    fun onInterceptTouchEvent

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        Log.e(TAG, "onTouchEvent" + super.onTouchEvent(event));

        return super.onTouchEvent(event)
    }
}
