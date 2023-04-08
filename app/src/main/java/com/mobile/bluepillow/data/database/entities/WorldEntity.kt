package com.mobile.bluepillow.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Worlds")
data class WorldEntity(
    @PrimaryKey(autoGenerate = true) var id:Int,
    @ColumnInfo(name = "world", defaultValue = "world") var worldName:String
    )

