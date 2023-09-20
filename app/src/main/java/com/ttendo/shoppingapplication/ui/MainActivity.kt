package com.ttendo.shoppingapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ttendo.shoppingapplication.R
import com.ttendo.shoppingapplication.ui.adapter.ProductAdapter
import com.ttendo.shoppingapplication.data.retrofit.RetrofitInstance
import com.ttendo.shoppingapplication.vm.MainViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    val viewModel:MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CoroutineScope(Dispatchers.IO).launch {
            try {

                val products = viewModel.getProducts()
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