package com.lgy.animatorprac

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_layout_animator.*

class LayoutAnimatorActivity : AppCompatActivity() {

    val adapter by lazy {
        RvAdapter(this, listOf("content1", "title", "name"))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layout_animator)
        initRecy()
    }

    private fun initRecy() {
        add.setOnClickListener { }
        delete.setOnClickListener { }
        val linealoutManager = LinearLayoutManager(this)
        linealoutManager.orientation = LinearLayoutManager.VERTICAL
        rvList.layoutManager = linealoutManager
        rvList.adapter = adapter
    }
}
