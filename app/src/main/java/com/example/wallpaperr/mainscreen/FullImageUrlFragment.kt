package com.example.wallpaperr.mainscreen


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders

import com.example.wallpaperr.R
import com.example.wallpaperr.databinding.FragmentFullImageUrlBinding
import com.example.wallpaperr.model.ImageRepository
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class FullImageUrlFragment : Fragment() {
    lateinit var binding: FragmentFullImageUrlBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFullImageUrlBinding.inflate(inflater)
        binding.lifecycleOwner = this

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var fullImage = FullImageUrlFragmentArgs.fromBundle(arguments!!).selectedImage
        binding.images = fullImage
    }
}
