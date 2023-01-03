package com.kerimbr.kotlinsuperleague.ui.players

import androidx.databinding.ViewDataBinding
import com.kerimbr.kotlinsuperleague.databinding.FragmentPlayersBinding
import com.kerimbr.kotlinsuperleague.ui.base.BaseFragment

class PlayersFragment : BaseFragment() {

    private var _binding: FragmentPlayersBinding? = null
    private val binding get() = _binding!!

    override fun initBinding(): ViewDataBinding {
        _binding = FragmentPlayersBinding.inflate(layoutInflater)
        return binding
    }


}