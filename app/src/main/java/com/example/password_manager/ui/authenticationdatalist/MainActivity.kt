package com.example.password_manager.ui.authenticationdatalist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.password_manager.R
import com.example.password_manager.data.local.db.AuthenticationDataDatabase
import com.example.password_manager.data.local.repositories.AuthenticationDataRepository
import com.example.password_manager.other.AuthenticationDataAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val database = AuthenticationDataDatabase(this)

        val repository = AuthenticationDataRepository(database)

        val factory = AuthenticationDataViewModelFactory(repository)

        val viewModel = ViewModelProviders.of(this, factory).get(AuthenticationDataViewModel::class.java)

        val adapter = AuthenticationDataAdapter(this, listOf(), viewModel)

        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = adapter

        viewModel.observeAuthenticationDataItems().observe(this, Observer {
            adapter.items = it
            adapter.notifyDataSetChanged()
        })


    }
}