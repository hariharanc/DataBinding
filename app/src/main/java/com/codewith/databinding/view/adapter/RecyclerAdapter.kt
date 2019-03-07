package com.codewith.databinding.view.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.codewith.databinding.R
import com.codewith.databinding.databinding.RecyclerItemBinding
import com.codewith.databinding.model.Employee


class RecyclerAdapter(val context: Context, val empList: ArrayList<Employee>, val itemclickListner: ItemclickListner) :
    RecyclerView.Adapter<ViewHolder>() {

    override fun getItemCount(): Int {
        return empList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.employee = empList[position]

        /*  val employee=empList[position]
           holder.binding.setVariable(BR.employee,employee)
           holder.binding.executePendingBindings()*/

        holder.binding.root.setOnClickListener {
            itemclickListner.clickItem(it, position)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.getContext())
        val binding: RecyclerItemBinding = DataBindingUtil.inflate(inflater, R.layout.recycler_item, parent, false)

        return ViewHolder(binding)
    }
}

interface ItemclickListner {
    fun clickItem(view: View, position: Int)

}

class ViewHolder(var binding: RecyclerItemBinding) : RecyclerView.ViewHolder(binding.root)




