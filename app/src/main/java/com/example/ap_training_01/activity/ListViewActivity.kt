package com.example.ap_training_01.activity

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ap_training_01.adapters.MyCustomAdapter
import com.example.ap_training_01.databinding.ActivityListViewBinding
import com.example.ap_training_01.model.Student

class ListViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListViewBinding
    private var myList = ArrayList<Student>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        myList.add(Student("Rakesh", "1234567890"))
        myList.add(Student("Sandeep", "1231231230"))
        myList.add(Student("Murari", "231231230"))
        myList.add(Student("Shagun", "12304567890"))
        val myAdapter = MyCustomAdapter(myList)

        binding.myListView.adapter = myAdapter

        binding.myListView.setOnItemClickListener(object: AdapterView.OnItemClickListener {
            override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val student: Student = parent?.getItemAtPosition(position) as Student
                Toast.makeText(this@ListViewActivity, student.name, Toast.LENGTH_SHORT).show()
            }

        })

    }
}