package com.i4bchile.desafiorestapi


import retrofit2.Response
import retrofit2.http.GET

interface Api {


    @GET("/users")
    suspend fun getAllUsers (): Response<List<User>>
}
