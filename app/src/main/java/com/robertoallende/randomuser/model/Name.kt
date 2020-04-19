package com.robertoallende.randomuser.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = Name.TABLE, primaryKeys = ["first", "last"])
@JsonClass(generateAdapter = true)
data class Name(

    @ColumnInfo(name = "first")
    @Json(name = "first")
    var first: String,

    @ColumnInfo(name = "last")
    @Json(name = "last")
    var last: String,

    @ColumnInfo(name = "title")
    @Json(name = "title")
    var title: String?
) : Parcelable {

    fun fullName(): String = "$title $first $last"

    companion object {
        const val TABLE = "NameEntity"
    }

}
