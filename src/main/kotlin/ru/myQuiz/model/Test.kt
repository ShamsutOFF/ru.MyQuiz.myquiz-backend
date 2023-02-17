package ru.myQuiz.model

import kotlinx.serialization.Serializable

@Serializable
data class Test(
    val testStringParam:String,
    val testIntParam:Int
)
