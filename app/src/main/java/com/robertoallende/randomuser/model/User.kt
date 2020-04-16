package com.robertoallende.randomuser.model

import androidx.room.*
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Entity(tableName = User.TABLE)
@JsonClass(generateAdapter = true)
data class User(

    @PrimaryKey(autoGenerate = true)
    var userId: Long?,

    @ColumnInfo(name = "cell")
    @Json(name = "cell")
    var cell: String?,

    @Embedded
    @Json(name = "dob")
    var dob: Dob?,

    @ColumnInfo(name = "email")
    @Json(name = "email")
    var email: String?,

    @ColumnInfo(name = "gender")
    @Json(name = "gender")
    var gender: String?,

    @Embedded
    @Json(name = "id")
    var id: Id?,

    @Embedded
    @Json(name = "location")
    var location: Location?,

    @Embedded
    @Json(name = "login")
    var login: Login?,

    @Embedded
    @Json(name = "name")
    var name: Name,

    @ColumnInfo(name = "nat")
    @Json(name = "nat")
    var nat: String?,

    @ColumnInfo(name = "phone")
    @Json(name = "phone")
    var phone: String?,

    @Embedded
    @Json(name = "picture")
    var picture: Picture?,

    @Embedded
    @Json(name = "registered")
    var registered: Registered?
) {

    fun genderCapitalized() = gender?.capitalize() ?: ""

    companion object {
        const val TABLE = "UserEntity"
    }

}