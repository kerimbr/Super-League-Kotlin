package com.kerimbr.kotlinsuperleague.ui.main

import android.os.Bundle
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
    }

}