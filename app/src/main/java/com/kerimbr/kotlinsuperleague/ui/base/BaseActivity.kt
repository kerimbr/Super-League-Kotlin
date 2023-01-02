package com.kerimbr.kotlinsuperleague.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract  class BaseActivity : AppCompatActivity() {

    /**
     * Override for set view model
     */
    open fun observeViewModel() {}

    /**
     * Override for set data/view binding
     */
    abstract fun initBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initBinding()
        observeViewModel()
    }


}