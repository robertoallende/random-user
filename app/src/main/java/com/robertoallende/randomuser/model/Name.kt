package com.robertoallende.randomuser.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Entity(tableName = Name.TABLE)
@JsonClass(generateAdapter = true)
data class Name(

    @PrimaryKey(autoGenerate = true)
    var nameId: Long?,

    @ColumnInfo(name = "first")
    @Json(name = "first")
    var first: String?,

    @ColumnInfo(name = "last")
    @Json(name = "last")
    var last: String?,

    @ColumnInfo(name = "title")
    @Json(name = "title")
    var title: String?) {

    companion object {
        const val TABLE = "NameEntity"
    }

}