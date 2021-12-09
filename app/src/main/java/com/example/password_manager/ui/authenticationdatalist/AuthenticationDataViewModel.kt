package com.example.password_manager.ui.authenticationdatalist

import androidx.lifecycle.ViewModel
import com.example.password_manager.data.local.db.entities.AuthenticationDataItem
import com.example.password_manager.data.local.repositories.AuthenticationDataRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AuthenticationDataViewModel(
    private val repository: AuthenticationDataRepository
): ViewModel() {

    fun insertAuthenticationDataItem(authenticationDataItem: AuthenticationDataItem) = CoroutineScope(Dispatchers.Main)
        .launch {
            repository.insertAuthenticationDataItem(authenticationDataItem)
        }

    fun deleteAuthenticationDataItem(authenticationDataItem: AuthenticationDataItem) = CoroutineScope(Dispatchers.Main)
        .launch {
            repository.deleteAuthenticationDataItem(authenticationDataItem)
        }

    fun updateAuthenticationDataItem(authenticationDataItem: AuthenticationDataItem) = CoroutineScope(Dispatchers.Main)
        .launch {
            repository.updateAuthenticationDataItem(authenticationDataItem)
        }

    fun observeAuthenticationDataItems() = repository.observeAuthenticationDataItems()
}