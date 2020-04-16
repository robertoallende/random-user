package com.robertoallende.randomuser.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
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
) : Parcelable {

    companion object {
        const val TABLE = "CoordinatesEntity"
    }

}