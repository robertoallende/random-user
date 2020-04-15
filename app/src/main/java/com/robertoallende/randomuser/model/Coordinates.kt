package com.robertoallende.randomuser.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Entity(tableName = Coordinates.TABLE)
@JsonClass(generateAdapter = true)
data class Coordinates(

    @PrimaryKey(autoGenerate = true)
    var coordinatesId: Long?,

    @ColumnInfo(name = "latitude")
    @Json(name = "latitude")
    val latitude: String?,

    @ColumnInfo(name = "longitude")
    @Json(name = "longitude")
    val longitude: String?
) {

    companion object {
        const val TABLE = "CoordinatesEntity"
    }

}