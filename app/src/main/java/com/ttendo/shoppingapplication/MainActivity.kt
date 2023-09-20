package com.ttendo.shoppingapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CoroutineScope(Dispatchers.IO).launch {
            try {
                val service = RetrofitInstance().createProductService()
                val products = service.getProducts()

                withContext(Dispatchers.Main) {
                    val productView = findViewById<RecyclerView>(R.id.my_view)
                    val productAdapter = ProductAdapter(this@MainActivity, products)
                    productView.adapter = productAdapter
                    productView.layoutManager = LinearLayoutManager(this@MainActivity)
//                    productView.layoutManager = LinearLayoutManager(this@MainActivity)
                    productView.layoutManager = GridLayoutManager(this@MainActivity, 2)

                }
            } catch (t: Throwable) {
                Toast.makeText(this@MainActivity, "No internet Connection", Toast.LENGTH_LONG).show()
            }

        }
    }
}