package com.i4bchile.desafiorestapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.i4bchile.desafiorestapi.databinding.ActivityMainBinding
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    private val userVM:UsersVM by viewModels()
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       Timber.plant(Timber.DebugTree())
       val adapter=UserAdapter()
       userVM.userList.observe(this, {
            adapter.updateAdapter(it)
        })

       binding= ActivityMainBinding.inflate(layoutInflater)
       binding.rvUsers.adapter=adapter
       binding.rvUsers.layoutManager=LinearLayoutManager(this)
       setContentView(binding.root)
    }
}