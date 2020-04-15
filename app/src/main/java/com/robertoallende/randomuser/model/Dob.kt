package com.robertoallende.randomuser.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Entity(tableName = Dob.TABLE)
@JsonClass(generateAdapter = true)
data class Dob(

    @PrimaryKey(autoGenerate = true)
    var dobId: Long?,

    @ColumnInfo(name = "age")
    @Json(name = "age")
    val age: Int?,

    @ColumnInfo(name = "date")
    @Json(name = "date")
    val date: String?
) {
    companion object {
        const val TABLE = "DobEntity"
    }

}