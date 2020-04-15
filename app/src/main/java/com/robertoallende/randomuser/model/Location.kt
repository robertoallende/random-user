package com.robertoallende.randomuser.model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Entity(tableName = Location.TABLE)
@JsonClass(generateAdapter = true)
data class Location(

    @PrimaryKey(autoGenerate = true)
    var locationId: Long?,

    @ColumnInfo(name = "city")
    @Json(name = "city")
    val city: String?,

    @Embedded
    @Json(name = "coordinates")
    val coordinates: Coordinates?,

    @ColumnInfo(name = "country")
    @Json(name = "country")
    val country: String?,

    @ColumnInfo(name = "postcode")
    @Json(name = "postcode")
    val postcode: Int?,

    @ColumnInfo(name = "state")
    @Json(name = "state")
    val state: String?,

    @Embedded
    @Json(name = "street")
    val street: Street?,

    @Embedded
    @Json(name = "timezone")
    val timezone: Timezone?
) {

    companion object {
        const val TABLE = "LocationEntity"
    }

}