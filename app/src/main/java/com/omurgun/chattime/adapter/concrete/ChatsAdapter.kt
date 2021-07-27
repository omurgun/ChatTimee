package com.omurgun.chattime.adapter.concrete

import android.widget.ImageView
import android.widget.TextView
import com.omurgun.chattime.R
import com.omurgun.chattime.adapter.baseAdapter.BaseRecyclerviewAdapter
import com.omurgun.chattime.model.response.ResponseChats
import com.omurgun.chattime.util.ProjectConstants
import com.omurgun.chattime.util.Util
import com.omurgun.chattime.util.downloadFromUrl
import com.omurgun.chattime.view.fragment.ChatsFragmentDirections
import com.omurgun.chattime.view.fragment.ContainerFragmentDirections

class ChatsAdapter (private val chats: ArrayList<ResponseChats>) : BaseRecyclerviewAdapter<ResponseChats>(chats, R.layout.item_chats){


    override fun onBindViewHold(position: Int, holder: BaseRecyclerviewViewHolder) {


        holder.itemView.findViewById<TextView>(R.id.chatsUserTitle).text = chats[position].title
        holder.itemView.findViewById<TextView>(R.id.chatsUserBody).text = chats[position].body

        holder.itemView.findViewById<ImageView>(R.id.chatsUserImage).downloadFromUrl(chats[position].image,
            Util.placeholderProgressBar(holder.itemView.context))



        holder.itemView.setOnClickListener {
            val action = ContainerFragmentDirections.actionContainerFragmentToChatFragment()
            ProjectConstants.PROJECT_NAV_CONTROLLER.navigate(action)


        }

    }


    fun updateChats(newChats: ArrayList<ResponseChats>) {
        updateValues(newChats)
    }
}

