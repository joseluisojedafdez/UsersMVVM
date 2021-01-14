package com.i4bchile.desafiorestapi;

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class UsersVM: ViewModel(){

    private val repository=Repository()



    val userList=repository.getUserList()

    init {

        viewModelScope.launch{
            repository.loadUserList()
        }


    }



}
