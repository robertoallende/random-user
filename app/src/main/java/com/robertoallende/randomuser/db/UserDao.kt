package com.robertoallende.randomuser.db

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.robertoallende.randomuser.model.User

/**
 * Room data access object for accessing the [User] table.
 */
@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(users: List<User>)

    // TODO: Change email by name and order by name
    @Query("SELECT * FROM ${User.TABLE} WHERE (email LIKE :queryString) ORDER BY userId ASC")
    fun usersByName(queryString: String): DataSource.Factory<Int, User>

    @Query("SELECT * FROM ${User.TABLE} ORDER BY userId ASC")
    fun allUsers(): DataSource.Factory<Int, User>
}
