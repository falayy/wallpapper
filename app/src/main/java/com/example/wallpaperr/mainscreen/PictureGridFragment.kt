package com.example.wallpaperr.mainscreen


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.example.wallpaperr.App

import com.example.wallpaperr.base.BaseFragment
import com.example.wallpaperr.databinding.FragmentPictureGridBinding
import com.example.wallpaperr.di.viewmodel.ImagesAppViewModelFactory
import com.example.wallpaperr.images.ImageViewModel
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class PictureGridFragment : BaseFragment() {


    @Inject
    lateinit var viewModelFactory : ImagesAppViewModelFactory

    lateinit var pictureGridBinding: FragmentPictureGridBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        pictureGridBinding = FragmentPictureGridBinding.inflate(inflater)
        pictureGridBinding.lifecycleOwner = this
        return pictureGridBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (mainActivity.applicationContext as App).component.inject(this)
        val viewModel = ViewModelProviders.of(this, viewModelFactory).get(ImageViewModel::class.java)
        pictureGridBinding.viewmodel = viewModel
        viewModel.getListOfImages()
        pictureGridBinding.imageGridRecyclerView.adapter = PictureGridAdapter {
            //view model gets full image
        }



    }
}
