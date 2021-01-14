package com.i4bchile.desafiorestapi

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database (entities=[User::class],version=1)
abstract class UserDatabase: RoomDatabase() {
    abstract fun userDao():UserDao
}

class UserApplication: Application() {

    companion object {
        var userDatabase:UserDatabase?=null

    }

    override fun onCreate(){
        super.onCreate()
        userDatabase=Room.databaseBuilder(this,UserDatabase::class.java,"user_db").build()
    }

}

