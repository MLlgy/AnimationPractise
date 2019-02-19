package com.lgy.animatorprac

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity

object IntentUtils {


    fun showIntent(context: Context,clazz: Class<out AppCompatActivity>){
        val intent: Intent = Intent()
        intent.setClass(context,clazz)
        context.startActivity(intent)
    }
}