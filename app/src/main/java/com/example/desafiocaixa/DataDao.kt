package com.example.desafiocaixa

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DataDao {

    @Query("SELECT * FROM data")
    fun getAll(): List<Data>

    @Insert
    fun insertData(data: Data)

}