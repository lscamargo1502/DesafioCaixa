package com.example.desafiocaixa

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



class PostsActivity : AppCompatActivity() {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val api = retrofit.create(PostsApi::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_posts)

        val rvPosts = findViewById<RecyclerView>(R.id.rv_posts)


        //Chamada em segundo plano
        runBlocking {
            launch {
                val postsResponse = api.getPosts()

                val postAdapter = PostAdapter(postsResponse)

                rvPosts.adapter = postAdapter

            }
        }


    }
}