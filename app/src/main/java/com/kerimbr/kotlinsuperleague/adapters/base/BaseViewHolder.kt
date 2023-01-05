package com.kerimbr.kotlinsuperleague.adapters.base

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

class BaseViewHolder<BINDING : ViewDataBinding>(val binding: BINDING) :
    RecyclerView.ViewHolder(binding.root) {


}