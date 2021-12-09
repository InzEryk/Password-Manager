package com.example.password_manager.data.local.repositories

import com.example.password_manager.data.local.db.AuthenticationDataDatabase
import com.example.password_manager.data.local.db.entities.AuthenticationDataItem

class AuthenticationDataRepository(
    private val db: AuthenticationDataDatabase
) {
    suspend fun insertAuthenticationDataItem(authenticationDataItem: AuthenticationDataItem) = db.getAuthenticationDataDao().insertAuthenticationDataItem(authenticationDataItem)

    suspend fun deleteAuthenticationDataItem(authenticationDataItem: AuthenticationDataItem) = db.getAuthenticationDataDao().deleteAuthenticationDataItem(authenticationDataItem)

    fun observeAuthenticationDataItems() = db.getAuthenticationDataDao().observeAuthenticationDataItems()
}