package com.example.wallpaperr

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.navigateUp
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
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

//    private fun setUpNavigation() {
//        setSupportActionBar(toolbar)
//        appBarConfiguration = AppBarConfiguration(navController.graph)
//        supportActionBar!!.setDisplayShowTitleEnabled(false)
//
//
//    }
//
//    fun setUpToolBar(toolbarTitle: String, isRootPage: Boolean = false) {
//        supportActionBar!!.run {
//            setDisplayHomeAsUpEnabled(!isRootPage)
//            setHomeAsUpIndicator(if (!isRootPage) R.drawable.ic_arrow_back_black_24dp else 0)
//            toolbar.title = toolbarTitle
//        }
    }








