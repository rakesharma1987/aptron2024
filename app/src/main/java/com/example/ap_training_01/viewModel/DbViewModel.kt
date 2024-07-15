package com.example.ap_training_01.viewModel

import androidx.lifecycle.ViewModel
import com.example.ap_training_01.model.User
import com.example.ap_training_01.repository.DbRepository

class DbViewModel(private val dbRepositor: DbRepository): ViewModel() {
    fun saveData(fName: String, lName:String, email: String, profile: String){
        dbRepositor.saveData(fName, lName, email, profile)
    }

    fun getUserData(): ArrayList<User> = dbRepositor.getData()

}