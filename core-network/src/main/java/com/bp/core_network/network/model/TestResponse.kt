package com.bp.core_network.network.model

import com.squareup.moshi.Json

data class TestResponse (
    @field:Json(name = "id") val id : Int,
    @field:Json(name = "title") val title : String
    )