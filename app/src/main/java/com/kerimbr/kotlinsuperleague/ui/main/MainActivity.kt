package com.kerimbr.kotlinsuperleague.ui.main

import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.kerimbr.kotlinsuperleague.databinding.ActivityMainBinding
import com.kerimbr.kotlinsuperleague.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : BaseActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun initBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBottomNavigationBar()
    }


    private fun setupBottomNavigationBar(){
        val navHostFragment = supportFragmentManager.findFragmentById(
            binding.mainFragmentContainerView.id
        ) as NavHostFragment
        val navController = navHostFragment.findNavController()
        val bottomNavBar = binding.mainBottomNav
        setupWithNavController(bottomNavBar, navController)
    }

}