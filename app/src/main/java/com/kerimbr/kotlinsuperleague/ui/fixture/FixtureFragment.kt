package com.kerimbr.kotlinsuperleague.ui.fixture

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import com.kerimbr.kotlinsuperleague.databinding.FragmentFixtureBinding
import com.kerimbr.kotlinsuperleague.ui.base.BaseFragment

class FixtureFragment : BaseFragment() {

    private var _binding: FragmentFixtureBinding? = null
    private val binding get() = _binding!!


    override fun initBinding(): ViewDataBinding {
        _binding = FragmentFixtureBinding.inflate(layoutInflater)
        return binding
    }



}