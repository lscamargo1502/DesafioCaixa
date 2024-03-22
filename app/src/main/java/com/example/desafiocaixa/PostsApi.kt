package com.example.desafiocaixa

import retrofit2.http.GET

interface PostsApi {

    @GET("posts")
    suspend fun getPosts(): List<PostResponse>

}