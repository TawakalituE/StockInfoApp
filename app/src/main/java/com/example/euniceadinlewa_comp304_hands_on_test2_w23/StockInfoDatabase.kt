package com.example.euniceadinlewa_comp304_hands_on_test2_w23

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [StockInfo::class], version = 1, exportSchema = false)
abstract class StockInfoDatabase : RoomDatabase() {

    abstract fun stockInfoDao(): StockInfoDao

    companion object {
        @Volatile
        private var INSTANCE: StockInfoDatabase? = null

        fun getDatabase(context: Context): StockInfoDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    StockInfoDatabase::class.java,
                    "stock_info_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
