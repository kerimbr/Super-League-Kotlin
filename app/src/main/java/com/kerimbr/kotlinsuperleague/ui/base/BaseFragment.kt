package com.kerimbr.kotlinsuperleague.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {

    /**
     * Override for set data binding
     */
    abstract fun initBinding() : ViewDataBinding

    /**
     * Returns the view returned from [initBinding]
     */
    open fun setView() : View{
        val vdb : ViewDataBinding = initBinding()
        return vdb.root
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return setView()
    }

}