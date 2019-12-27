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
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.example.wallpaperr.App
import com.example.wallpaperr.R
import com.example.wallpaperr.di.viewmodel.ImagesAppViewModelFactory
import com.example.wallpaperr.images.ImageViewModel
import timber.log.Timber
import java.io.IOException
import javax.inject.Inject


/**
 * A simple [Fragment] subclass.
 */
class FullImageUrlFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ImagesAppViewModelFactory

    lateinit var viewModel: ImageViewModel
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
        (mainActivity.applicationContext as App).component.inject(this)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(ImageViewModel::class.java)
        fullImage = FullImageUrlFragmentArgs.fromBundle(arguments!!).selectedImage
        binding.images = fullImage
        binding.fabAction.setOnClickListener {
            MaterialDialog(context!!).show {
                title(R.string.title)
                message(R.string.title_message)
                positiveButton(R.string.agree)
                negativeButton(R.string.disagree)
                positiveButton(R.string.agree) { dialog ->
                    viewModel.decode(Glide.with(this@FullImageUrlFragment), fullImage.fullImage)
                    onGetBitmap()
                }
                negativeButton(R.string.disagree) {
                    dismiss()
                }
            }
        }
    }

    fun onGetBitmap() {
        viewModel.imageBitmap.observe(this, Observer {
            try {
                val wallpaperManager = WallpaperManager.getInstance(context!!)
                wallpaperManager.setBitmap(it)
            } catch (e: Exception) {

            }
        })
    }


}
