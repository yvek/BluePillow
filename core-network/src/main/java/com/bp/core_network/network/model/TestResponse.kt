package com.bp.core_network.network.model

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class TestResponse (
    @Json(name = "userId") val userId : Int,
    @Json(name = "id") val id : Int,
    @Json(name = "completed") val completed : Int,
    @Json(name = "title") val title : String
)