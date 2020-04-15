package com.robertoallende.randomuser.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Entity(tableName = Street.TABLE)
@JsonClass(generateAdapter = true)
data class Street(

    @PrimaryKey(autoGenerate = true)
    var streetId: Long?,

    @ColumnInfo(name = "name")
    @Json(name = "name")
    val name: String?,

    @ColumnInfo(name = "number")
    @Json(name = "number")
    val number: Int?

){

    companion object {
        const val TABLE = "StreetEntity"
    }

}