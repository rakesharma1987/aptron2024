package com.example.ap_training_01.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.ap_training_01.databinding.LayoutUserDataBinding
import com.example.ap_training_01.model.User

class UserInfoListAdapter(private var myList: List<User>): BaseAdapter() {
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
        var binding = LayoutUserDataBinding.inflate(LayoutInflater.from(parent?.context), parent, false)
        var myView: View = binding.root
        binding.tvName.text = "${myList[position].fName} ${myList[position].lName}"
        binding.tvEmail.text = myList[position].email
        return myView
    }
}