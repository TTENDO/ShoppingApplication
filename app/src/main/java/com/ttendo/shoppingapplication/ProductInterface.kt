package com.ttendo.shoppingapplication

import retrofit2.http.GET

interface ProductInterface {
    @GET("products")
    suspend fun getProducts():List<ProductsResponse>
}