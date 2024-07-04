package com.example.ap_training_01.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ap_training_01.databinding.CustomListItemBinding
import com.example.ap_training_01.interfaces.OnItemClickListener
import com.example.ap_training_01.model.User

class GridRecyclerviewAdapter(val list: List<User>):RecyclerView.Adapter<GridRecyclerviewAdapter.MyViewHolder>(){
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
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val user = list[position]
        holder.binding.tvName.text = user.fName+ " " + user.lName
        holder.binding.tvMobileNo.text = user.email
    }
}