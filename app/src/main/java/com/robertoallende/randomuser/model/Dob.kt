package com.robertoallende.randomuser.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize
import java.text.SimpleDateFormat
import java.util.*

@Parcelize
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
) : Parcelable {

    fun asString(): String {
        val apiIsoFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US)
        val humanFormat = SimpleDateFormat("MMM dd, yyyy", Locale.US)

        val apiDate = apiIsoFormat.parse(date)
        return humanFormat.format(apiDate)
    }

    companion object {
        const val TABLE = "DobEntity"
    }

}