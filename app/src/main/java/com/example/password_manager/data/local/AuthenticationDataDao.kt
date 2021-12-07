package com.example.password_manager.data.local

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface AuthenticationDataDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAuthenticationDataItem(authenticationDataItem: AuthenticationDataItem)

    @Delete
    suspend fun deleteAuthenticationDataItem(authenticationDataItem: AuthenticationDataItem)

    @Query("SELECT * FROM authentication_data_items")
    fun observeAuthenticationDataItems(): LiveData<List<AuthenticationDataItem>>

}