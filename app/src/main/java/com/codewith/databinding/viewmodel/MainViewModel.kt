package com.codewith.databinding.viewmodel

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import java.util.*

class MainViewModel : Observable(), LifecycleObserver {
    val obserVerOperation = ObservableField<String>()
    fun performClickOperation(msg: String) {
        obserVerOperation.set(msg)
        setChanged()
        notifyObservers(msg)

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun oncreate(){
        Log.i("MainViewModel", "MainViewModel Oncreate")
    }
}