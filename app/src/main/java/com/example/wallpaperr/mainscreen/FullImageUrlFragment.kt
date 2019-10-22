package com.example.wallpaperr.mainscreen


import android.app.WallpaperManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.afollestad.materialdialogs.MaterialDialog

import com.example.wallpaperr.base.BaseFragment
import com.example.wallpaperr.databinding.FragmentFullImageUrlBinding
import com.example.wallpaperr.domain.Images
import android.graphics.BitmapFactory
import com.bumptech.glide.Glide
import com.example.wallpaperr.R
import timber.log.Timber
import java.io.IOException





/**
 * A simple [Fragment] subclass.
 */
class FullImageUrlFragment : BaseFragment() {
    lateinit var binding: FragmentFullImageUrlBinding
    lateinit var fullImage: Images

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
        fullImage = FullImageUrlFragmentArgs.fromBundle(arguments!!).selectedImage
        binding.images = fullImage
        binding.fabAction.setOnClickListener {
            MaterialDialog(context!!).show {
                title(R.string.title)
                message(R.string.title_message)
                positiveButton(R.string.agree)
                negativeButton(R.string.disagree)
                positiveButton(R.string.agree) { dialog ->

                }

                negativeButton(R.string.disagree) {
                    dismiss()
                }
            }
        }
    }





}
