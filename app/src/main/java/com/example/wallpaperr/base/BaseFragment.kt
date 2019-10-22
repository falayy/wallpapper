package com.example.wallpaperr.base


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.StringRes
import com.example.wallpaperr.MainActivity

import com.example.wallpaperr.R

/**
 * A simple [Fragment] subclass.
 */
abstract class BaseFragment : Fragment() {

    protected val mainActivity : MainActivity
    get(){
        return activity as? MainActivity ?: throw IllegalStateException("Not attached!")
    }

    override fun onStart(){
        super.onStart()
    }

    override fun onDestroyView() {
        super.onDestroyView()

    }



}
