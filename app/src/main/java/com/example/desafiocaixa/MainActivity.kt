package com.example.desafiocaixa

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val data: Uri? = intent?.data

        val edtApelido = findViewById<TextInputEditText>(R.id.edt_apelido)

        val btnSalvar = findViewById<Button>(R.id.btn_salvar)
        val btnPosts = findViewById<Button>(R.id.btn_posts)
        val btnApelidos = findViewById<Button>(R.id.btn_apelidos)

        val txtPat = findViewById<TextView>(R.id.txt_pat)

        val pat = data?.getQueryParameter("pat")


        pat?.let {
            txtPat.visibility = View.VISIBLE
            txtPat.text = "PAT: $it"
            btnSalvar.isEnabled = true
        }


        btnSalvar.setOnClickListener {

            edtApelido.text?.let { apelido ->
                val toastMessage = when {

                    apelido.length < 3 -> "Apelido precisa ter mais do que tres caracteres"
                    apelido.length > 20 -> "Apelido precisa ter menos do que vinte caracteres"

                    else -> {

                        val dataList = MyApplication.database?.dataDao()?.getAll()

                        val apelidoEncontrado = dataList?.find {
                            it.apelido == apelido.toString()
                        }
                        if (apelidoEncontrado == null) {

                            pat?.let {
                                saveData(it, apelido.toString())
                            }


                            "Apelido validado com sucesso!"

                        } else {
                            "Apelido já utilizado"
                        }


                    }


                }
                Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show()
            }
        }

        btnPosts.setOnClickListener {

            val intent = Intent(this, PostsActivity::class.java)
            startActivity(intent)
        }
        btnApelidos.setOnClickListener {

            val intent = Intent(this, ApelidosActivity::class.java)
            startActivity(intent)
        }

    }

    fun saveData(pat: String, apelido: String) {

        runBlocking {
            launch {
                val data = Data(pat = pat, apelido = apelido)
                MyApplication.database?.dataDao()?.insertData(data)
            }
        }

    }

}