package com.cinemagia.Data.API

import com.cinemagia.Data.Model.Pelicula
import com.cinemagia.Data.Model.Usuario
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ServiceAPI {
    @GET("api/user")
    suspend fun getUser(): List<Usuario>


    @GET("api/movies")
    suspend fun getMovies(): List<Pelicula>

    @GET("api/movies/{id}")
    suspend fun getMovies(@Path ("id") id: String): Pelicula

}

object ApiApp{

    private val logging = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val okHttp = OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()
    val moshi = com.squareup.moshi.Moshi.Builder()
        .add(com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory())
        .build()

    val api: ServiceAPI  = Retrofit.Builder()
        .baseUrl("https://project-7iuso.vercel.app/")
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()
        .create(ServiceAPI::class.java)
}





