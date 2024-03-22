package com.example.desafiocaixa

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class ApelidosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_apelidos)

        val rvApelidos = findViewById<RecyclerView>(R.id.rv_apelidos)

        runBlocking {
            launch {
                val apelidosResponse = MyApplication.database?.dataDao()?.getAll()

                val apelidoAdapter = ApelidoAdapter(apelidosResponse.orEmpty())

                rvApelidos.adapter = apelidoAdapter

            }
        }


    }
}