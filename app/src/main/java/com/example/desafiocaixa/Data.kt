package com.example.desafiocaixa

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Data(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    val apelido: String,
    val pat: String
)
