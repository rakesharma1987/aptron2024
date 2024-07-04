package com.example.ap_training_01.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.ap_training_01.repository.DbRepository
import com.example.ap_training_01.viewModel.DbViewModel

class DbFactory(private val dbRepository: DbRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DbViewModel::class.java)){
            return DbViewModel(dbRepository) as T
        }

        throw IllegalArgumentException("Unknown class")
    }
}