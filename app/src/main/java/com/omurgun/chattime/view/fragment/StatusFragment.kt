package com.omurgun.chattime.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.omurgun.chattime.adapter.concrete.StatusAdapter
import com.omurgun.chattime.databinding.FragmentStatusBinding
import com.omurgun.chattime.model.response.ResponseStatus

class StatusFragment : Fragment() {
    private var _binding: FragmentStatusBinding? = null
    private val binding get() = _binding!!
    private val statusAdapter = StatusAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStatusBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setStatus(getStatusData())
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setStatus(status : ArrayList<ResponseStatus>){
        binding.statusRv.adapter = statusAdapter
        binding.statusRv.layoutManager = LinearLayoutManager(context)

        statusAdapter.updateStatus(status)

    }

    private fun getStatusData() : ArrayList<ResponseStatus>{
        val status = arrayListOf<ResponseStatus>()
        status.add(ResponseStatus(1,"ömür","Bugün nasılsın.",""))
        status.add(ResponseStatus(2,"ömür","Bugün nasılsın.",""))
        status.add(ResponseStatus(3,"ömür","Bugün nasılsın.",""))
        status.add(ResponseStatus(4,"ömür","Bugün nasılsın.",""))
        status.add(ResponseStatus(5,"ömür","Bugün nasılsın.",""))
        status.add(ResponseStatus(6,"ömür","Bugün nasılsın.",""))
        status.add(ResponseStatus(7,"ömür","Bugün nasılsın.",""))


        return status

    }
}