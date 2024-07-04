package com.example.ap_training_01.kotlinSyntex

class Student {
    var name: String = "Rakesh"


    fun m1(){
        println(name.equals("AAA"))

        val s1 = Student()
        println(s1.hashCode())
    }
}