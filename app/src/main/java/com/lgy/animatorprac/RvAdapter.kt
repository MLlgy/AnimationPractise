package com.lgy.animatorprac

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.rv_item.view.*

/**
 * Author：lee
 * Data: 19-3-4 21:49
 */
class RvAdapter(val context: Context,val list: List<String>) : RecyclerView.Adapter<RvAdapter.RvViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int) =
            RvViewHolder(LayoutInflater.from(context).inflate(R.layout.rv_item, parent, false))


    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: RvViewHolder, p1: Int) {
        holder.tvContent.text = list.get(p1)
    }

    class RvViewHolder(itemVI: View) : RecyclerView.ViewHolder(itemVI) {
        val tvContent = itemVI.tvContent
    }
}