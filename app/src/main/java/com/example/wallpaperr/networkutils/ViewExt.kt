package com.example.wallpaperr.networkutils

import android.view.View
import android.view.ViewGroup
import androidx.core.view.children


fun View.show() {
    visibility = View.VISIBLE
}

fun View.hide() {
    visibility = View.GONE
}

fun ViewGroup.showViewWithChildren() {
    show()
    for (view in children) {
        view.show()
    }
}