package com.lgy.animatorprac

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.view.animation.*
import kotlinx.android.synthetic.main.activity_view_animation.*

class ViewAnimationActivity : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_animation)
        rotateAnimation.setOnClickListener(this)
        alphAnimation.setOnClickListener(this)
        scaleAnimation.setOnClickListener(this)
        transalteAnimation.setOnClickListener(this)
        setAnimation.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

        when (v?.id) {
            rotateAnimation.id -> showRorateAnimation()
            alphAnimation.id -> showAlphAnimation()
            scaleAnimation.id -> showScaleAnimation()
            transalteAnimation.id -> showTransateAnimation()
            transalteAnimation.id -> showAnimationSet()
        }
    }

    private fun showAnimationSet() {
        val translate = TranslateAnimation(0f, 200f, 0f, 300f)
        val alph = AlphaAnimation(1.0f, 0.2f)

        val scale = ScaleAnimation(0f, 2f, 0f, 2f, ScaleAnimation.ZORDER_BOTTOM,
                0.5f, ScaleAnimation.RELATIVE_TO_SELF, 0.5f)

        val rorateAnimation = RotateAnimation(
                0f, 360f,
                viewRect.top + viewRect.width / 2.0f, viewRect.left + viewRect.width / 2f)
        val set = AnimationSet(true)
        set.addAnimation(translate)
        set.addAnimation(scale)
        set.addAnimation(rorateAnimation)
        set.addAnimation(alph)
        viewRect.startAnimation(set)

    }

    private fun showTransateAnimation() {
        val translate = TranslateAnimation(0f, 200f, 0f, 300f)
        translate.duration = 2000
        viewRect.startAnimation(translate)
    }

    private fun showScaleAnimation() {
//        val scale = ScaleAnimation(0f,2f,0f,2f)
        val scale = ScaleAnimation(0f, 2f, 0f, 2f, ScaleAnimation.ZORDER_BOTTOM,
                0.5f, ScaleAnimation.RELATIVE_TO_SELF, 0.5f)
        scale.duration = 2000
        viewRect.startAnimation(scale)

    }

    private fun showAlphAnimation() {
        val alph = AlphaAnimation(1.0f, 0.2f)
        alph.duration = 2000
        alph.repeatCount = 3
        alph.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationRepeat(animation: Animation?) {

            }

            override fun onAnimationEnd(animation: Animation?) {
                Log.d("uuu1", "onAnimationEnd")
            }

            override fun onAnimationStart(animation: Animation?) {
                Log.d("uuu2", "onAnimationEnd")

            }

        })


    }

    private fun showRorateAnimation() {
        val rorateAnimation = RotateAnimation(
                0f, 360f,
                viewRect.top + viewRect.width / 2.0f, viewRect.left + viewRect.width / 2f)
        rorateAnimation.duration = 2000
        viewRect.startAnimation(rorateAnimation)
    }
}
