package com.example.ap_training_01.interfaces

import com.example.ap_training_01.model.Student

interface OnItemClickListener {
    fun onItemClick(position: Int, student: Student)
}