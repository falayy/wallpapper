package com.example.wallpaperr.viewpager


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import com.example.wallpaperr.R
import com.example.wallpaperr.databinding.FragmentViewPagerBinding

/**
 * A simple [Fragment] subclass.
 */
class ViewPagerFragment : Fragment() {
   private lateinit var  binding : FragmentViewPagerBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

         binding = DataBindingUtil.inflate(inflater, R.layout.fragment_view_pager, container, false)
        return binding.root
    }


}
