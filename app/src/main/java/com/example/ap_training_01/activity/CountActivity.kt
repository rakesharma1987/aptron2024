package com.example.ap_training_01.activity

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.ap_training_01.R
import com.example.ap_training_01.databinding.ActivityCountBinding
import com.example.ap_training_01.viewModel.CountActivityViewModel

class CountActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityCountBinding
    private lateinit var myViewModel: CountActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCountBinding.inflate(layoutInflater)
        setContentView(binding.root)
        myViewModel = ViewModelProvider(this)[CountActivityViewModel::class.java]

        binding.tvCount.text = myViewModel.count.toString()

        binding.btnCount.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        myViewModel.increaseCount()
        binding.tvCount.text = myViewModel.count.toString()
    }


}