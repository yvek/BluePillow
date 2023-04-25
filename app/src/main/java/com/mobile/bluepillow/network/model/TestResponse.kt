package com.mobile.bluepillow.network.model

import com.google.gson.annotations.SerializedName
//import com.squareup.moshi.Json
//import com.squareup.moshi.JsonClass


//@JsonClass(generateAdapter = true)
data class TestResponse (
    @SerializedName("userId") val userId : Int,
    @SerializedName("id") val id : Int,
    @SerializedName("completed") val completed : Boolean,
    @SerializedName("title") val title : String
    )


//data class TestResponse (
//    @field:Json(name = "userId") val userId : Int,
//    @field:Json(name = "id") val id : Int,
//    @field:Json(name = "completed") val completed : Int,
//    @field:Json(name = "title") val title : String
//)