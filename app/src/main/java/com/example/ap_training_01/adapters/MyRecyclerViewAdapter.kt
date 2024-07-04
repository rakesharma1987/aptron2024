package com.example.ap_training_01.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ap_training_01.databinding.CustomListItemBinding
import com.example.ap_training_01.interfaces.OnItemClickListener
import com.example.ap_training_01.model.Student

class MyRecyclerViewAdapter(private val myList: List<Student>):  RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder>(){
    lateinit var onItemClickListener: OnItemClickListener

    fun setOnItemClickListeners(listener: OnItemClickListener){
        onItemClickListener = listener
    }

    inner class MyViewHolder(val binding: CustomListItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = CustomListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)

    }

    override fun getItemCount(): Int {
        return myList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val student = myList[position]
        holder.binding.tvName.text = student.name
        holder.binding.tvMobileNo.text = student.mobNo

        holder.itemView.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                onItemClickListener.onItemClick(position, student)
            }

        })
    }
}