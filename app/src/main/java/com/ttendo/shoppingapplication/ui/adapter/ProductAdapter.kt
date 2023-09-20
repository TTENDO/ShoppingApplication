package com.ttendo.shoppingapplication.ui.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.ttendo.shoppingapplication.ui.DetailsActivity
import com.ttendo.shoppingapplication.R
import com.ttendo.shoppingapplication.data.model.ProductsResponse

class ProductAdapter(val context: Context, val products: List<ProductsResponse>):
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    interface ItemClickListener {
        fun onIncrementClick(position: Int)
    }
    class ProductViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val image = view.findViewById<ImageView>(R.id.item_layout_firstImage)
        val name = view.findViewById<TextView>(R.id.item_layout_firstText)
        val price = view.findViewById<TextView>(R.id.item_layout_price)
        var quantity = view.findViewById<TextView>(R.id.item_layout_quantity)
        var addButton = view.findViewById<Button>(R.id.item_layout_add_btn)
        var minusButton = view.findViewById<Button>(R.id.minus_btn)
//        val rating = view.findViewById<TextView>(R.id.details_layout_ratingBar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val v = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false)
        return ProductViewHolder(v)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        Picasso.get().load(products[position].image).into(holder.image)
        holder.name.text = products[position].title
        holder.price.text = "${products[position].price}"
//        holder.rating.rating = products[position].rating.rate?.toFloat() ?: 0.0f

        val item = products[position]
        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetailsActivity::class.java)
            intent.putExtra("productName",item.title)
            intent.putExtra("price",item.price)
            intent.putExtra("rating",item.rating.rate)
            intent.putExtra("description",item.description)
            intent.putExtra("imageUrl",item.image)
            context.startActivity(intent)
        }
//        holder.addButton.setOnClickListener {
//            itemClickListener.onIncrementClick(position)
//        }
//        holder.addButton.setOnClickListener {
//            var currentQuantity:Long? = item?.quantity ?: products[position].quantity
//            var newCurrentQuantity : Long? = currentQuantity?.plus(1)
//            //holder.quantity.text = currentQuantity.toString()
//            holder.quantity.text = newCurrentQuantity.toString()
//        }

    }
}