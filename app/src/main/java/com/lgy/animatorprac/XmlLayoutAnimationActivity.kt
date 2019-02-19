package com.lgy.animatorprac

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_layout_animation.*
import kotlinx.android.synthetic.main.layout_animatino_item.view.*
import java.util.*
import kotlin.collections.ArrayList

class XmlLayoutAnimationActivity : AppCompatActivity() {

    lateinit var list : ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layout_animation)
        initData()
        initView()

    }

    private fun initData() {
        list = Arrays.asList("353","4646","353","353","353","353","353","353") as ArrayList<String>
    }

    private fun initView() {
        val layoutManager = LinearLayoutManager(this)
        val adapter = Adapter(this,list)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        itemsRcy.layoutManager = layoutManager

        itemsRcy.adapter = adapter
        addDataBtn.setOnClickListener {
            adapter.addData()
        }

    }

    private class Adapter(context: Context, list: ArrayList<String>) : RecyclerView.Adapter<Adapter.ViewHolder>() {
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

        fun addData() {
        }


        class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            var itemView2: TextView = itemView.itemTv as TextView
        }
    }
}
