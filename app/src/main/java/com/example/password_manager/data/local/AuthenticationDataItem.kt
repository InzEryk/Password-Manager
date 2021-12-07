package com.example.password_manager.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "authentication_data_items")
data class AuthenticationDataItem(
    @ColumnInfo(name = "authentication_data_title")
    var title: String,
    @ColumnInfo(name = "authentication_data_login")
    var login: String,
    @ColumnInfo(name = "authentication_data_password")
    var password: String
) {
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null
}