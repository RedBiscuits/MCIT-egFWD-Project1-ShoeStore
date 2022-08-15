package com.udacity.shoestore.ui

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ActivityMainBinding
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    //--------------------------------------------------------------------------------------------------------------------
    //  Tried to do back button on appbar but it kept always show that error (code is commeneted below)                   |
    //                                                                                                                    |
    //    java.lang.RuntimeException: Unable to start activity                                                            |
    //    ComponentInfo{com.udacity.shoestore/com.udacity.shoestore.ui.MainActivity}:                                     |
    //    java.lang.NullPointerException: Attempt to invoke virtual method                                                |
    //    'void androidx.appcompat.app.ActionBar.setTitle(java.lang.CharSequence)' on a null object reference             |
    //                                                                                                                    |
    //--------------------------------------------------------------------------------------------------------------------

    private val binding : ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val viewModel by lazy {
        ViewModelProvider(this)[ShoeViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(false)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.myNavHostFragment) as
                    NavHostFragment
        val navController = navHostFragment.navController
        setupActionBarWithNavController(navController)
        val appBarConfiguration = AppBarConfiguration(setOf(
            R.id.homeFragment,
            R.id.loginFragment
            ))

        binding.toolbar.setupWithNavController(navController,appBarConfiguration)
        viewModel.setShoes()

        Timber.plant(Timber.DebugTree())
    }

}
