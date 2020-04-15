package com.robertoallende.randomuser.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Entity(tableName = Login.TABLE)
@JsonClass(generateAdapter = true)
data class Login(

    @PrimaryKey(autoGenerate = true)
    var loginId: Long?,

    @ColumnInfo(name = "md5")
    @Json(name = "md5")
    val md5: String?,

    @ColumnInfo(name = "password")
    @Json(name = "password")
    val password: String?,

    @ColumnInfo(name = "salt")
    @Json(name = "salt")
    val salt: String?,

    @ColumnInfo(name = "sha1")
    @Json(name = "sha1")
    val sha1: String?,

    @ColumnInfo(name = "sha256")
    @Json(name = "sha256")
    val sha256: String?,

    @ColumnInfo(name = "username")
    @Json(name = "username")
    val username: String?,

    @ColumnInfo(name = "uuid")
    @Json(name = "uuid")
    val uuid: String?
) {
    companion object {
        const val TABLE = "LoginEntity"
    }
}