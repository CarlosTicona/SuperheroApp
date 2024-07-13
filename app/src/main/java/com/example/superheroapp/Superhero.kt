package com.example.superheroapp

import java.io.Serializable

data class Superhero(
    val realName: String,
    val superheroName: String,
    val companyName: String,
    val imageResourceId: Int
) : Serializable
