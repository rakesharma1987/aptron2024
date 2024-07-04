package com.example.ap_training_01.viewModel

import androidx.lifecycle.ViewModel

class CountActivityViewModel: ViewModel() {
    var count = 0

    fun increaseCount(){
        count = count.plus(1)
    }
}