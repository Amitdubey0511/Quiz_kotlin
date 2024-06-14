package com.example.quiz

data class Questions(
    val id:Int,
    val question:String,
    val optionone:String,
    val optiontwo:String,
    val optionthree:String,
    val optionfour:String,
    val correctanswer:Int
)
