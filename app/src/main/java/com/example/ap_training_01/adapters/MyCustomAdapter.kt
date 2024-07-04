package com.example.ap_training_01.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.ap_training_01.databinding.CustomListItemBinding
import com.example.ap_training_01.model.Student

class MyCustomAdapter(private var myList: List<Student>): BaseAdapter() {
    override fun getCount(): Int {
        return myList.size
    }

    override fun getItem(position: Int): Any {
        return myList[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var binding = CustomListItemBinding.inflate(LayoutInflater.from(parent?.context), parent, false)
        var myView: View = binding.root
        binding.tvName.text = myList[position].name
        binding.tvMobileNo.text = myList[position].mobNo
        return myView
    }
}