package com.example.wallpaperr

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.navigateUp
import com.afollestad.materialdialogs.MaterialDialog
import com.example.wallpaperr.mainscreen.LoadingCallback
import com.example.wallpaperr.networkutils.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.loading_status.*


class MainActivity : AppCompatActivity() ,LoadingCallback {
    private lateinit var navController : NavController
    private lateinit var appBarConfiguration : AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navController = this.findNavController(R.id.nav_host_fragment)
        onSupportNavigateUp()
//        setUpNavigation()
    }


    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }

    override fun showLoading() {
        showLoading(R.string.default_loading_message)
    }

    override fun showLoading(resId: Int) {
        showLoading(getString(resId))
    }

    override fun showLoading(message: String) {
        hideKeyBoard()
        progressMessage.text = message
        loading_layout_container.showViewWithChildren()
        disableTouch()
    }

    override fun dismissLoading() {
        loading_layout_container.hide()
        enableTouch()
    }

    override fun showError(resId: Int) {
        showError(getString(resId))
    }

    override fun showError(message: String) {
        hideKeyBoard()
        dismissLoading()
        MaterialDialog(this).show {
            title(text = message)
            positiveButton(R.string.ok)
        }
    }
    }








