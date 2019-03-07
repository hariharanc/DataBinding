package com.codewith.databinding.view.activity

import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil

import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.codewith.databinding.R
import com.codewith.databinding.databinding.ActivityRecyclerBinding


import com.codewith.databinding.view.adapter.RecyclerAdapter
import com.codewith.databinding.viewmodel.EmployeeViewModel
import kotlinx.android.synthetic.main.activity_recycler.*

class RecyclerviewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityRecyclerBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_recycler)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(DividerItemDecoration(this, LinearLayout.VERTICAL))

        val employeeViewModel=EmployeeViewModel(this)
       val adapter = RecyclerAdapter(this,employeeViewModel.getEmpLst())
        binding.recyclerView.adapter = adapter
    }
}