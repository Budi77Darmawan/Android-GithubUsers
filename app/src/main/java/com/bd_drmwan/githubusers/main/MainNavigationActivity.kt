package com.bd_drmwan.githubusers.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.bd_drmwan.githubusers.R
import com.bd_drmwan.githubusers.databinding.ActivityMainNavigationBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainNavigationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainNavigationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainNavigationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        onViewCreated()
    }

    private fun onViewCreated() {
        initBottomNavigation()
    }

    private fun initBottomNavigation() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.main_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        binding.bottomNav.setupWithNavController(navController)

        binding.bottomNav.setOnItemReselectedListener {
            return@setOnItemReselectedListener
        }

        navController.addOnDestinationChangedListener { _, destination, _ ->

        }
    }
}