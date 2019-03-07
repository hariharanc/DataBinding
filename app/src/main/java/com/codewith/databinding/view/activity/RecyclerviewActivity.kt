package com.codewith.databinding.view.activity

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil

import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.codewith.databinding.R
import com.codewith.databinding.databinding.ActivityRecyclerBinding
import com.codewith.databinding.model.Employee
import com.codewith.databinding.view.adapter.ItemclickListner
import com.codewith.databinding.view.adapter.RecyclerAdapter
import com.codewith.databinding.viewmodel.EmployeeViewModel
import kotlinx.android.synthetic.main.activity_recycler.*

class RecyclerviewActivity : AppCompatActivity(), ItemclickListner {
    lateinit var employeeList: ArrayList<Employee>
    lateinit var recyclerAdapter: RecyclerAdapter
    lateinit var binding: ActivityRecyclerBinding
    lateinit var employeeViewModel:EmployeeViewModel
    override fun clickItem(view: View, position: Int) {
        if (employeeList.size > 5) {
            employeeList.removeAt(employeeList.size - 1)
            recyclerAdapter.notifyDataSetChanged()
        }else{
            employeeViewModel.addEmployee()
            recyclerAdapter.notifyDataSetChanged()
        }
        /* when (view.id) {
             R.id.imgProf -> {

             }*/
        /* else -> Toast.makeText(
             this,
             "Selected Item Position:" + employeeList.get(position).name,
             Toast.LENGTH_SHORT
         ).show()*/

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =
            DataBindingUtil.setContentView(this, R.layout.activity_recycler)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(DividerItemDecoration(this, LinearLayout.VERTICAL))

         employeeViewModel = EmployeeViewModel(this)
        employeeList = employeeViewModel.getEmpLst()
        recyclerAdapter = RecyclerAdapter(this, employeeList, this)
        binding.recyclerView.adapter = recyclerAdapter
    }
}