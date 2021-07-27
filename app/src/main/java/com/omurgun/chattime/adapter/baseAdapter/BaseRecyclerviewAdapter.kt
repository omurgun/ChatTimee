package com.omurgun.chattime.adapter.baseAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerviewAdapter<T>(private val values: ArrayList<T>, private val layoutResId : Int) : RecyclerView.Adapter<BaseRecyclerviewAdapter.BaseRecyclerviewViewHolder>() {

    class BaseRecyclerviewViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseRecyclerviewViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(layoutResId, parent, false)
        return BaseRecyclerviewViewHolder(view)

    }

    override fun getItemCount(): Int {
        return values.size
    }

    override fun onBindViewHolder(holder: BaseRecyclerviewViewHolder, position: Int) {
        onBindViewHold(position,holder)
    }

    abstract fun onBindViewHold(position: Int, holder: BaseRecyclerviewViewHolder)

    open fun updateValues(newValues: ArrayList<T>) {
        values.clear()
        values.addAll(newValues)
        notifyDataSetChanged()
    }

}