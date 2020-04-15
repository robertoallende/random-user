package com.robertoallende.randomuser.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Entity(tableName = Id.TABLE)
@JsonClass(generateAdapter = true)
data class Id(

    @PrimaryKey(autoGenerate = true)
    var idId: Long?,

    @ColumnInfo(name = "id_name")
    @Json(name = "name")
    val name: String?,

    @ColumnInfo(name = "value")
    @Json(name = "value")
    val value: String?
) {
    companion object {
        const val TABLE = "IdEntity"
    }
}