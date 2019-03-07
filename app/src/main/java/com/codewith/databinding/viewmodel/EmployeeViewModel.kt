package com.codewith.databinding.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.codewith.databinding.model.Employee
import android.R
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide


class EmployeeViewModel(val context: Context) : ViewModel() {

    val employeeList: ArrayList<Employee> = ArrayList()

    fun getEmpLst(): ArrayList<Employee> {
        for (i in 0..10) {
            employeeList.add(
                Employee(
                    "name" + i.toString(),
                    "https://pbs.twimg.com/profile_images/446522135721164800/pdVA44as.jpeg"
                )
            )
        }
        return employeeList
    }

    fun addEmployee() {
        employeeList.add(
            Employee(
                "name" + employeeList.size.toString(),
                "https://pbs.twimg.com/profile_images/446522135721164800/pdVA44as.jpeg"
            )
        )
    }

}