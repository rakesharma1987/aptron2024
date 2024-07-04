package com.example.ap_training_01.activity

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.ap_training_01.R

class SecondActivity : AppCompatActivity() {
    lateinit var tvName: TextView
    lateinit var tvGender: TextView
    lateinit var tvAge: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        tvName = findViewById(R.id.tv_name)
        tvGender = findViewById(R.id.tv_gender)
        tvAge = findViewById(R.id.tv_age)

        val myIntent = intent
//        val name = myIntent.getStringExtra("name")
//        val gender = myIntent.getStringExtra("gender")
        val bundle = myIntent.extras
        val name = bundle!!.getString("name")
        val gender = bundle!!.getString("gender")
        val age = bundle!!.getInt("age")

        tvName.text = "Name: $name"
        tvGender.text= "Gender: $gender"
        tvAge.text = "Age: ${age.toString()}"





    }
}