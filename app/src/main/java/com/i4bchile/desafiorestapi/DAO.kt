package com.i4bchile.desafiorestapi

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {

    @Insert (onConflict=OnConflictStrategy.REPLACE)
    suspend fun insertUsers(list:List<User>)

    @Query("SELECT * FROM user")
    fun getUsers():LiveData<List<User>>

}