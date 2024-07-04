package com.example.ap_training_01.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ap_training_01.R
import com.example.ap_training_01.adapters.GridRecyclerviewAdapter
import com.example.ap_training_01.adapters.UserInfoListAdapter
import com.example.ap_training_01.dataBase.DbAdapter
import com.example.ap_training_01.databinding.ActivityGridUserBinding

class GridUserActivity : AppCompatActivity() {
    lateinit var binding: ActivityGridUserBinding
    private lateinit var myDbAdapter: DbAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGridUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        myDbAdapter = DbAdapter(this)

        val userList = myDbAdapter.getData()
        val userListAdapter = GridRecyclerviewAdapter(userList)
        binding.rvUser.adapter = userListAdapter
        userListAdapter.notifyDataSetChanged()

    }
}