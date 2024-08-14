package com.example.euniceadinlewa_comp304_hands_on_test2_w23

class StockInfoRepository(private val stockInfoDao: StockInfoDao) {
    suspend fun insert(stockInfo: StockInfo) {
        stockInfoDao.insert(stockInfo)
    }

    suspend fun getStockInfo(stockSymbol: String): StockInfo? {
        return stockInfoDao.getStockInfo(stockSymbol)
    }
}
