package com.lgy.animatorprac

import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.ComponentName
import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.*
import android.view.animation.AnimationUtils
import android.view.animation.LayoutAnimationController
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_layout_animation.*
import kotlinx.android.synthetic.main.layout_animatino_item.view.*
import java.util.*


class CodeLayoutAnimationActivity : AppCompatActivity() {

    lateinit var list: List<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layout_animation)
        initData()
        initView()
//        initGestureDetector()
//        initJobScheduler()
    }

    private fun initJobScheduler() {
        val jobScheduler: JobScheduler = getSystemService(Context.JOB_SCHEDULER_SERVICE) as JobScheduler
        val jobService: ComponentName = ComponentName(this, MyJobService::class.java)
        val jobInfo = JobInfo.Builder(123, jobService)
                .setMinimumLatency(5000)
                .setOverrideDeadline(60000)
                .setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED)
                .setRequiresDeviceIdle(true)
                .setPersisted(true)
                .setBackoffCriteria(3000, JobInfo.BACKOFF_POLICY_LINEAR)
                .build()

        jobScheduler.schedule(jobInfo)

//        jobScheduler.cancel(123)
//        jobScheduler.cancelAll()

    }

    private fun initGestureDetector() {
        val detector = GestureDetector(this, object : GestureDetector.SimpleOnGestureListener() {
            override fun onSingleTapConfirmed(e: MotionEvent): Boolean {
                Toast.makeText(this@CodeLayoutAnimationActivity, "单击", Toast.LENGTH_SHORT).show()
                return false
            }

            override fun onDoubleTap(e: MotionEvent): Boolean {
                Toast.makeText(this@CodeLayoutAnimationActivity, "双击", Toast.LENGTH_SHORT).show()
                return false
            }

            override fun onDoubleTapEvent(e: MotionEvent?): Boolean {
                Toast.makeText(this@CodeLayoutAnimationActivity, "双击 onDoubleTapEvent", Toast.LENGTH_SHORT).show()
                return false
            }

            override fun onDown(e: MotionEvent?): Boolean {
                return true
            }

            override fun onFling(e1: MotionEvent?, e2: MotionEvent?, velocityX: Float, velocityY: Float): Boolean {
//                return super.onFling(e1, e2, velocityX, velocityY)
                return true
            }


        })

        addDataBtn.setOnTouchListener { _, event -> detector.onTouchEvent(event) }


    }

    private fun initData() {
        list = Arrays.asList("353", "4646", "353", "353", "353", "353", "353", "353")
    }

    private fun initView() {
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        itemsRcy.layoutManager = layoutManager
        itemsRcy.adapter = Adapter(this, list)
        // 使用 Kotlin 代码实现 布局动画
        val animationUtils = AnimationUtils.loadAnimation(this, R.anim.slide_in_left)
        val layoutAnimatinoController = LayoutAnimationController(animationUtils)
        layoutAnimatinoController.delay = 0.5f
        itemsRcy.layoutAnimation = layoutAnimatinoController
        itemsRcy.startLayoutAnimation()

    }

    private class Adapter(context: Context, list: List<String>) : RecyclerView.Adapter<Adapter.ViewHolder>() {
        var context: Context? = null
        var size: Int = 0
        var list: List<String>? = null

        init {
            this.context = context;
            size = list.size
            this.list = list
        }

        override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int) = ViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_animatino_item, viewGroup, false))


        override fun getItemCount() = list!!.size

        override fun onBindViewHolder(viewHolder: ViewHolder, pos: Int) {
            viewHolder.itemView2.text = list!!.get(pos)
        }


        class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            var itemView2: TextView = itemView.itemTv as TextView
        }
    }
}
