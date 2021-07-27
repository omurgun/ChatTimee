package com.omurgun.chattime.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.omurgun.chattime.adapter.concrete.ChatsAdapter
import com.omurgun.chattime.databinding.FragmentChatsBinding
import com.omurgun.chattime.model.response.ResponseChats


class ChatsFragment : Fragment() {

    private var _binding: FragmentChatsBinding? = null
    private val binding get() = _binding!!
    private val chatsAdapter = ChatsAdapter(arrayListOf())




    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChatsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setChats(getChatsData())
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setChats(chats : ArrayList<ResponseChats>){
        binding.chatsRv.adapter = chatsAdapter
        binding.chatsRv.layoutManager = LinearLayoutManager(context)

        chatsAdapter.updateChats(chats)

    }

    private fun getChatsData() : ArrayList<ResponseChats>{
        val chats = arrayListOf<ResponseChats>()
        chats.add(ResponseChats(1,"ömür","Bugün nasılsın.",""))
        chats.add(ResponseChats(2,"ömür","Bugün nasılsın.",""))
        chats.add(ResponseChats(3,"ömür","Bugün nasılsın.",""))
        chats.add(ResponseChats(4,"ömür","Bugün nasılsın.",""))
        chats.add(ResponseChats(5,"ömür","Bugün nasılsın.",""))

        return chats

    }
}