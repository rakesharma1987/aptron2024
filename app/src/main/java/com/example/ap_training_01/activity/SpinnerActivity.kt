package com.example.ap_training_01.activity

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ap_training_01.R
import com.example.ap_training_01.databinding.ActivitySpinnerBinding

class SpinnerActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    private lateinit var binding: ActivitySpinnerBinding
    private lateinit var courseList: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySpinnerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        courseList = ArrayList<String>()
        courseList.add("Select Course")
        courseList.add("Kotlin")
        courseList.add("Java")
        courseList.add("Android")
        courseList.add("Flutter")
        courseList.add("Swift")
        courseList.add("C++")
        courseList.add("C#")
        courseList.add("Python")
        courseList.add("India")
        courseList.add("Indonesia")
        courseList.add("Japan")
        courseList.add("Malaysia")

        val arrayAdapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, courseList)
        binding.spinner.adapter = arrayAdapter

        binding.spinner.onItemSelectedListener = this

        val arrayAdapter1 = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, courseList)
       binding.tvAutoCompleteTxtview.setAdapter(arrayAdapter1)
        binding.tvAutoCompleteTxtview.threshold = 1



    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val spinnerValue = parent!!.getItemAtPosition(position).toString()
        Log.d("SpinnerActivity", "$spinnerValue")
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        Log.d("TAG", "onNothingSelected: ")
    }
}