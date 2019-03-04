package com.lgy.animatorprac

import android.animation.*
import android.graphics.drawable.Animatable
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.view.animation.AccelerateInterpolator
import android.view.animation.BounceInterpolator
import android.view.animation.DecelerateInterpolator
import android.widget.Toast
import com.lgy.animatorprac.valurAnimatorOfObject.CharEvalutor
import kotlinx.android.synthetic.main.activity_object_animatior.*

class ObjectAnimatorActivity : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_object_animatior)
        btnTransalteAnimator.setOnClickListener(this)
        btnScaleAnimator.setOnClickListener(this)
        btnProperValueHolder.setOnClickListener(this)
        btnAnimatorSet.setOnClickListener(this)
        btnValueAnimator.setOnClickListener(this)
        svgAnimator.setOnClickListener(this)
        view.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnScaleAnimator -> scaleAnimator()
            R.id.btnTransalteAnimator -> translateAnimator()
            R.id.btnProperValueHolder -> properValueAnimator()
            R.id.btnAnimatorSet -> animatorSet()
            R.id.btnValueAnimator -> valueAnimator()

            R.id.svgAnimator -> {
//                svgAnimatorFun()
//                svgAnimatorFun1()
                svgAnimatorFun2()
            }
            R.id.view -> showToast()
        }
    }

    private fun svgAnimatorFun2() {

        val drawable = ivSvg2.drawable
        if (drawable is Animatable) {
            val iv = ivSvg2.drawable as Animatable

            iv.start()
        }
    }


    private fun svgAnimatorFun1() {
//        val drawable = ivSvg1.drawable
//        if (drawable is Animatable) {
//            val iv = ivSvg1.drawable as Animatable
//            iv.start()
//        }

//        val animator = resources.getDrawable(R.drawable.ic_line) as AnimatedVectorDrawable
//        ivSvg1.setImageDrawable(animator)
//        animator.start()
    }

    private fun svgAnimatorFun() {
        val drawable = ivSvg.drawable
        if (drawable is Animatable) {
            val iv = ivSvg.drawable as Animatable

            iv.start()
        }

    }

    private fun valueAnimator() {
//        valueAnimatorOne()
//        valueAnimatorTwo()
//        valueAnimatorThree()
//        valueAnimatorFour()
        valueAnimatorFive()
    }

    private fun valueAnimatorFive() {
        val animator = ObjectAnimator.ofInt(cusObjectAnimator, "PointRadius", 0, 300, 100)
        animator.duration = 3000
        animator.interpolator = BounceInterpolator()
        animator.start()
    }

    private fun valueAnimatorFour() {
        pointView.doAnimator()
    }

    private fun valueAnimatorThree() {
        val animator = ValueAnimator.ofObject(CharEvalutor(), 'A', 'Z')
        animator.addUpdateListener { animation ->
            val text = animation.animatedValue as Char
            textView.text = text.toString()
        }
        animator.duration = 10000
        animator.setEvaluator(CharEvalutor())
        animator.interpolator = AccelerateInterpolator()
        animator.start()
    }

    private fun valueAnimatorTwo() {
        val valueAnimator = ValueAnimator.ofFloat(0f, 100f)
        valueAnimator.addUpdateListener { valueAnimator ->
            tvValueAnimator.text = valueAnimator.animatedValue.toString()
        }
        valueAnimator.duration = 3000
        valueAnimator.start()
    }

    private fun valueAnimatorOne() {
        val valueAnimator = ValueAnimator.ofInt(0, 150)
        val left = view.left
        val top = view.top
        val x = view.x
        val y = view.y
        valueAnimator.addUpdateListener { valueAnimator1 ->
            val fraction = valueAnimator1.animatedFraction
            Log.e("Fraction Listener", fraction.toString())
            val currentValue = valueAnimator1.animatedValue as Int
            Log.e("Evalutor Listener", currentValue.toString())
            view.layout(left + currentValue, top + currentValue, left + currentValue + view.width, top + currentValue + view.height)

        }
        valueAnimator.duration = 5000

        valueAnimator.addListener(object : Animator.AnimatorListener {
            override fun onAnimationRepeat(animation: Animator?) {


            }

            override fun onAnimationEnd(animation: Animator?) {
            }

            override fun onAnimationCancel(animation: Animator?) {
            }

            override fun onAnimationStart(animation: Animator?) {
            }
        })
        valueAnimator.interpolator = CustomeInterplotor()
        valueAnimator.setEvaluator(CustomTypeEvalutor())
        valueAnimator.start()

    }

    private fun animatorSet() {
        val translationX = ObjectAnimator.ofFloat(view, "translationX", 200f)
        val scaleX = ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 0f, 1f)
        val alpha = ObjectAnimator.ofFloat(view, "alpha", 1f, 0f, 1f)
        val set = AnimatorSet()
        val list = listOf(translationX, scaleX, alpha)
        set.playTogether(list)
        set.duration = 5000
//        set.interpolator = BounceInterpolator()
        set.start()
    }

    private fun showToast() {
        Toast.makeText(this, "click", Toast.LENGTH_SHORT).show()
    }

    private fun translateAnimator() {
        val tranlate = ObjectAnimator.ofFloat(view, "translationX", 300f)
        tranlate.duration = 3000
        tranlate.start()

    }

    private fun properValueAnimator() {
        val translation = PropertyValuesHolder.ofFloat("translationX", 300f)
        val scaleX = PropertyValuesHolder.ofFloat("scaleX", 1f, 0f, 1f)
        val scaleY = PropertyValuesHolder.ofFloat("scaleY", 1f, 0f, 1f)
        val alpha = PropertyValuesHolder.ofFloat("alpha", 1f, 0f, 1f)
        val objectAnimator = ObjectAnimator.ofPropertyValuesHolder(view, translation, scaleX, scaleY, alpha)
        objectAnimator.duration = 3000
        objectAnimator.start()

    }

    private fun scaleAnimator() {
        val scale = ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 0.3f, 0.2f, 0f, 0.5f)
        scale.duration = 5000
        scale.interpolator = DecelerateInterpolator()
        scale.start()
    }
}
