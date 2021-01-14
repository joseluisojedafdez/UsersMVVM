package com.i4bchile.desafiorestapi


import androidx.lifecycle.LiveData
import timber.log.Timber

class Repository {

    private val userDatabase=UserApplication.userDatabase!!


    suspend fun loadUserList(){
        val response=RetrofitClient.retrofitInstance().getAllUsers()

                when (response.isSuccessful) {
                    true -> response.body()?.let {
                        Timber.d("respuesta exitosa con ${response.body()?.size}")
                        userDatabase.userDao().insertUsers(it)
                    }
                    false -> Timber.d("Ocurrió un error ${response.errorBody()}")
                }

    }

    fun getUserList(): LiveData<List<User>> {

        return userDatabase.userDao().getUsers()
    }
}