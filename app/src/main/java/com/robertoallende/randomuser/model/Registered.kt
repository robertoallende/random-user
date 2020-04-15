package com.robertoallende.randomuser.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Entity(tableName = Registered.TABLE)
@JsonClass(generateAdapter = true)
data class Registered(

    @PrimaryKey(autoGenerate = true)
    var registeredId: Long?,

    @Json(name = "age")
    @ColumnInfo(name = "registered_age")
    val age: Int?,

    @Json(name = "date")
    @ColumnInfo(name = "registered_date")
    val date: String?

) {
    companion object {
        const val TABLE = "RegisteredEntity"
    }
}