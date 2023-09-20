package com.ttendo.shoppingapplication

data class ProductsResponse(
    var id : Int?,
    var  title:String?,
    var price:Double?,
    var description:String?,
    var category: String?,
    var image: String?,
    var rating: Rating,
    var quantity:Long?=0
)
data class Rating(
    var rate:Double?,
    var count:Int?
)
