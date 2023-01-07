package com.kerimbr.kotlinsuperleague.ui.standings


import androidx.databinding.ViewDataBinding
import com.kerimbr.kotlinsuperleague.databinding.FragmentStandingsBinding
import com.kerimbr.kotlinsuperleague.ui.base.BaseFragment

class StandingsFragment : BaseFragment() {

    private var _binding: FragmentStandingsBinding? = null
    private val binding get() = _binding!!


    override fun initBinding(): ViewDataBinding {
        _binding = FragmentStandingsBinding.inflate(layoutInflater)
        return binding
    }


}