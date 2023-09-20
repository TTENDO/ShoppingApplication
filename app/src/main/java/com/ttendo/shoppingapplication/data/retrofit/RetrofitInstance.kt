package com.ttendo.shoppingapplication.data.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance{

//    fun createOkHttpClient(): OkHttpClient {
//        //create a logger
//        val interceptor = HttpLoggingInterceptor()
//        interceptor.level = HttpLoggingInterceptor.Level.BODY
//        return OkHttpClient.Builder().addInterceptor(interceptor).build()
//    }

    fun createProductService(): ProductInterface {
        val retrofit = Retrofit.Builder().baseUrl("https://fakestoreapi.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(ProductInterface::class.java)
        return service
    }
}