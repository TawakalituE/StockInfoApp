package com.example.euniceadinlewa_comp304_hands_on_test2_w23

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "stock_info")
data class StockInfo(
    @PrimaryKey
    @ColumnInfo(name = "stock_symbol")
    val stockSymbol: String,
    @ColumnInfo(name = "company_name")
    val companyName: String,
    @ColumnInfo(name = "stock_quote")
    val stockQuote: Double
)
