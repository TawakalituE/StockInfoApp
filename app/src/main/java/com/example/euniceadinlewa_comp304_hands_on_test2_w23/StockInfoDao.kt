package com.example.euniceadinlewa_comp304_hands_on_test2_w23

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface StockInfoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(stockInfo: StockInfo)

    @Query("SELECT * FROM stock_info WHERE stock_symbol = :stockSymbol LIMIT 1")
    suspend fun getStockInfo(stockSymbol: String): StockInfo?
}
