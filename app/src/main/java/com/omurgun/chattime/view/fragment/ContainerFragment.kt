package com.omurgun.chattime.view.fragment

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.google.android.material.appbar.AppBarLayout
import com.omurgun.chattime.R
import com.omurgun.chattime.adapter.concrete.SectionsPagerAdapter
import com.omurgun.chattime.databinding.FragmentContainerBinding
import com.omurgun.chattime.util.Util


class ContainerFragment : Fragment() {

    private var _binding: FragmentContainerBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentContainerBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.findViewById<AppBarLayout>(R.id.app_bar)?.visibility = View.VISIBLE
        setUpWithViewPager(binding.viewPager)
        binding.tabLayout.setupWithViewPager(binding.viewPager)

        binding.viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                changeFabICon(position)
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })
    }


    private fun setUpWithViewPager(viewPager: ViewPager) {
        val adapter = SectionsPagerAdapter(requireActivity().supportFragmentManager)
        adapter.addFragment(ChatsFragment(), "Chats")
        adapter.addFragment(StatusFragment(), "Status")
        adapter.addFragment(CallsFragment(), "Calls")
        viewPager.adapter = adapter
    }

    private fun changeFabICon(index: Int) {
        binding.fabAction.hide()
        Handler(Looper.getMainLooper()).postDelayed({
            when (index) {
                0 -> binding.fabAction.hide()
                1 -> {
                    binding.fabAction.show()
                    binding.fabAction.setImageDrawable(Util.getDrawable(R.drawable.ic_baseline_chat_24,requireActivity().theme))
                }
                2 -> {
                    binding.fabAction.show()
                    binding.fabAction.setImageDrawable(Util.getDrawable(R.drawable.ic_baseline_call_24,requireActivity().theme))
                }
            }
        }, 400)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}