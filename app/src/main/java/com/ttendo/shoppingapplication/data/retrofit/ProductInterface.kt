package com.ttendo.shoppingapplication.data.retrofit

import com.ttendo.shoppingapplication.data.model.ProductsResponse
import retrofit2.http.GET

interface ProductInterface {
    @GET("products")
    suspend fun getProducts():List<ProductsResponse>
}