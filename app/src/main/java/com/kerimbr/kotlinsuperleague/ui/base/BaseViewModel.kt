package com.kerimbr.kotlinsuperleague.ui.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

abstract class BaseViewModel : ViewModel(), CoroutineScope{

    // Job for coroutines
    private val job =  Job()

    // Coroutine context -> Dispatchers.Main for UI thread and
    // job for canceling all coroutines when the view model is cleared
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main


    // Dispose Job
    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }

}