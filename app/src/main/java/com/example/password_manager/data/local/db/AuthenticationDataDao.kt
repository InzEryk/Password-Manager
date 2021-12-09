package com.example.password_manager.data.local.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.password_manager.data.local.db.entities.AuthenticationDataItem

@Dao
interface AuthenticationDataDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAuthenticationDataItem(authenticationDataItem: AuthenticationDataItem)

    @Delete
    suspend fun deleteAuthenticationDataItem(authenticationDataItem: AuthenticationDataItem)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateAuthenticationDataItem(authenticationDataItem: AuthenticationDataItem)

    @Query("SELECT * FROM authentication_data_items")
    fun observeAuthenticationDataItems(): LiveData<List<AuthenticationDataItem>>

}