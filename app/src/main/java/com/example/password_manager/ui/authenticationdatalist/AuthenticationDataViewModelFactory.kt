package com.example.password_manager.ui.authenticationdatalist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.password_manager.data.local.repositories.AuthenticationDataRepository

class AuthenticationDataViewModelFactory(
    private val repository: AuthenticationDataRepository
): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AuthenticationDataViewModel(repository) as T
    }
}