package com.example.ap_training_01.activity

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ap_training_01.R
import com.example.ap_training_01.databinding.ActivitySharedPrefBinding

class SharedPrefActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivitySharedPrefBinding
    private lateinit var sharedPreferencences: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySharedPrefBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferencences = getSharedPreferences("aptron", MODE_PRIVATE)
        editor = sharedPreferencences.edit()




        binding.btnLogin.setOnClickListener(this)
        binding.btnRegister.setOnClickListener(this)


    }

    override fun onClick(v: View?) {
        if (v!!.id == R.id.btn_login) {
            val userId = sharedPreferencences.getString("fname", "")
            val pass = sharedPreferencences.getString("lname", "")
            if (userId!!.equals(binding.etFname.text.toString()) && pass!!.equals(binding.etLname.text.toString())) {
                val intent = Intent(this, WelcomeActivity::class.java)
                intent.putExtra("userId", binding.etFname.text.toString())
                startActivity(intent)
            }else{
                Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_SHORT).show()
            }

        }else{
            editor.putString("fname", binding.etFname.text.toString())
            editor.putString("lname", binding.etLname.text.toString())
            editor.commit()

            binding.etFname.setText("")
            binding.etLname.setText("")
        }
    }
}