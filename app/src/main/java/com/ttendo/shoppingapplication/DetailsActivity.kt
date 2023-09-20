package com.ttendo.shoppingapplication

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import org.w3c.dom.Text


class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

//        val image = intent.getIntExtra("image", R.drawable.ttendo_todo)
        val productName = intent.getStringExtra("productName")
        findViewById<TextView>(R.id.details_layout_prdct_name).text = productName.toString()

        val price = intent.getDoubleExtra("price",0.0)
        findViewById<TextView>(R.id.details_layout_prdct_price).text = price.toString()

        val rating = intent.getFloatExtra("rating",0.0f)
        val ratingBar = findViewById<RatingBar>(R.id.details_layout_ratingBar)
        ratingBar.rating = rating

        val ratingString =  rating.toString()
        findViewById<TextView>(R.id.details_layout_quantity).text = ratingString

        findViewById<TextView>(R.id.details_layout_desc).text = intent.getStringExtra("description")
        val imageUrl = intent.getStringExtra("imageUrl")
        Picasso.get().load(imageUrl).into(findViewById<ImageView>(R.id.details_layout_image))
    }

    override fun onBackPressed() {
        // Create an intent to navigate back to the home page (previous activity)
        val intent = Intent(this, MainActivity::class.java) // Replace HomePageActivity with the name of your home page activity
        startActivity(intent)
        finish() // Finish the current activity to remove it from the back stack
    }


}