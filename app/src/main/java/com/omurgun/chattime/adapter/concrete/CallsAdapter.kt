package com.omurgun.chattime.adapter.concrete

import android.widget.ImageView
import android.widget.TextView
import com.omurgun.chattime.R
import com.omurgun.chattime.adapter.baseAdapter.BaseRecyclerviewAdapter
import com.omurgun.chattime.model.response.ResponseCalls
import com.omurgun.chattime.util.Util
import com.omurgun.chattime.util.downloadFromUrl

class CallsAdapter (private val calls: ArrayList<ResponseCalls>) : BaseRecyclerviewAdapter<ResponseCalls>(calls, R.layout.item_calls){


    override fun onBindViewHold(position: Int, holder: BaseRecyclerviewViewHolder) {


        holder.itemView.findViewById<TextView>(R.id.callsUserTitle).text = calls[position].title
        holder.itemView.findViewById<TextView>(R.id.callsUserBody).text = calls[position].body

        holder.itemView.findViewById<ImageView>(R.id.callsUserImage).downloadFromUrl(calls[position].image,
            Util.placeholderProgressBar(holder.itemView.context))



        /*    holder.itemView.setOnClickListener {
                val action = ConsumptionContainerFragmentDirections.actionConsumptionContainerFragmentToNewsDetailFragment(news[position])
                ProjectConstants.PROJECT_NAV_CONTROLLER.navigate(action)

                if (ProjectConstants.PROJECT_DRAWER_LAYOUT.isOpen)
                {
                    ProjectConstants.PROJECT_DRAWER_LAYOUT.close()
                }

            }*/

    }


    fun updateCalls(newCalls: ArrayList<ResponseCalls>) {
        updateValues(newCalls)
    }
}
