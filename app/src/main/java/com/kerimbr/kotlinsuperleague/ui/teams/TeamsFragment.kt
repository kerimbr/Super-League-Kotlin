package com.kerimbr.kotlinsuperleague.ui.teams

import androidx.databinding.ViewDataBinding
import com.kerimbr.kotlinsuperleague.databinding.FragmentTeamsBinding
import com.kerimbr.kotlinsuperleague.ui.base.BaseFragment

class TeamsFragment : BaseFragment() {

    private var _binding: FragmentTeamsBinding? = null
    private val binding get() = _binding!!


    override fun initBinding(): ViewDataBinding {
        _binding = FragmentTeamsBinding.inflate(layoutInflater)
        return binding
    }


}