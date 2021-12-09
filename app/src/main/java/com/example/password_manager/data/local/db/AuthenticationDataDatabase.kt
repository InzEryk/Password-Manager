package com.example.password_manager.data.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.password_manager.data.local.db.entities.AuthenticationDataItem

@Database(
    entities = [AuthenticationDataItem::class],
    version = 1
)
abstract class AuthenticationDataDatabase: RoomDatabase() {

    abstract fun getAuthenticationDataDao(): AuthenticationDataDao

    companion object {
        @Volatile
        private var instance: AuthenticationDataDatabase? = null
        private var LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also {
                instance = it
            }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
                AuthenticationDataDatabase::class.java, "AuthenticationDB.db")
                .build()
    }

}