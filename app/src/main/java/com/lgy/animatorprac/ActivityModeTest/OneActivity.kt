package com.lgy.animatorprac.ActivityModeTest

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.lgy.animatorprac.R
import kotlinx.android.synthetic.main.activity_one.*

class OneActivity : AppCompatActivity() {
    companion object {
        val TAG = "TestOneActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_one)
        setSupportActionBar(toolbar)
//


        Log.e(TAG, "onCreate")
        fab.setOnClickListener { view ->
            //            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                    .setAction("Action", null).show()

            startActivity(Intent(this, SecondActivity::class.java))
//            finish()
        }
    }

    override fun onResume() {
        super.onResume()
        Log.e(TAG, "onResume")
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Log.e(TAG, "onNewIntent")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(TAG, "onDestroy")
    }
}
