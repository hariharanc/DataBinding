package com.codewith.databinding.view.activity


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import com.codewith.databinding.R
import com.codewith.databinding.databinding.ActivityMainBinding
import com.codewith.databinding.viewmodel.MainViewModel
import java.util.*


class MainActivity : AppCompatActivity(), Observer, LifecycleOwner {

   //var imageurl:String="https://pbs.twimg.com/profile_images/446522135721164800/pdVA44as.jpeg"
    private lateinit var lifecycleRegistry: LifecycleRegistry
    lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding: ActivityMainBinding =
        DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.activity = this
        mainViewModel = MainViewModel()
        mainViewModel.addObserver(this)
        lifecycleRegistry = LifecycleRegistry(this)
        lifecycleRegistry.markState(Lifecycle.State.CREATED)
        lifecycleRegistry.addObserver(mainViewModel)

    }

    fun onClick(view: View) {
        when (view.id) {
            R.id.btnRecycler -> {
                mainViewModel.performClickOperation("recycler")
            }
            else -> Log.i("Recycler", "Nothing")
        }
    }

    override fun update(o: java.util.Observable?, arg: Any?) {
        if (arg is String) {
            when (arg) {
                "recycler" -> startActivity(Intent(this, RecyclerviewActivity::class.java))
                else -> Log.i("Recycler", "Nothing")
            }

        }

    }

}