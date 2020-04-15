package com.robertoallende.randomuser.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Entity(tableName = Picture.TABLE)
@JsonClass(generateAdapter = true)
data class Picture(

    @PrimaryKey(autoGenerate = true)
    var pictureId: Long?,

    @ColumnInfo(name = "large")
    @Json(name = "large")
    val large: String?,

    @ColumnInfo(name = "medium")
    @Json(name = "medium")
    val medium: String?,

    @ColumnInfo(name = "thumbnail")
    @Json(name = "thumbnail")
    val thumbnail: String?
) {
    companion object {
        const val TABLE = "PictureEntity"
    }
}