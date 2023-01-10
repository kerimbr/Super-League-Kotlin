package com.kerimbr.kotlinsuperleague.adapters.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseRVAdapter<BINDING : ViewDataBinding, MODEL : Any>(
    private val items: List<MODEL>,
    val onItemClickListener: OnItemClickListener<MODEL>? = null
) : RecyclerView.Adapter<BaseViewHolder<BINDING>>() {

    interface OnItemClickListener<MODEL> {
        fun onItemClick(item: MODEL)
    }

    @get:LayoutRes
    abstract val layoutRes: Int

    abstract fun onBind(binding: BINDING, position: Int)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<BINDING> {
        val binder = DataBindingUtil.inflate<BINDING>(
            LayoutInflater.from(parent.context),
            layoutRes,
            parent,
            false
        )

        return BaseViewHolder(binder)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<BINDING>, position: Int) {
        onBind(holder.binding, position)
    }

    override fun getItemCount(): Int = items.size


}














