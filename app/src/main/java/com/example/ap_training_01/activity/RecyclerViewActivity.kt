package com.example.ap_training_01.activity

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ap_training_01.adapters.MyRecyclerViewAdapter
import com.example.ap_training_01.databinding.ActivityRecyclerViewBinding
import com.example.ap_training_01.interfaces.OnItemClickListener
import com.example.ap_training_01.model.Student

class RecyclerViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRecyclerViewBinding
    val myList = ArrayList<Student>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        myList.add(Student("Murari", "7894561230"))
        myList.add(Student("Sandeep", "1234567890"))
        myList.add(Student("Shagun", "1230123102"))
        myList.add(Student("Rakesh", "9635033237"))


//        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = GridLayoutManager(this@RecyclerViewActivity, 2)
        val myAdapter = MyRecyclerViewAdapter(myList)
        binding.recyclerView.adapter = myAdapter
        myAdapter.notifyDataSetChanged()

        myAdapter.setOnItemClickListeners(object: OnItemClickListener{
            override fun onItemClick(position: Int, student: Student) {
                Toast.makeText(this@RecyclerViewActivity, student.name, Toast.LENGTH_SHORT).show()
            }

        })

    }
}