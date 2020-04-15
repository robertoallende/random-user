package com.robertoallende.randomuser.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Entity(tableName = Timezone.TABLE)
@JsonClass(generateAdapter = true)
data class Timezone(

    @PrimaryKey(autoGenerate = true)
    var timezoneId: Long?,

    @ColumnInfo(name = "description")
    @Json(name = "description")
    val description: String?,

    @ColumnInfo(name = "offset")
    @Json(name = "offset")
    val offset: String?

) {
    companion object {
        const val TABLE = "TimezoneEntity"
    }
}