package com.example.euniceadinlewa_comp304_hands_on_test2_w23

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class StockInfoViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: StockInfoRepository

    init {
        val stockInfoDao = StockInfoDatabase.getDatabase(application).stockInfoDao()
        repository = StockInfoRepository(stockInfoDao)
    }

    fun insert(stockInfo: StockInfo) = viewModelScope.launch {
        repository.insert(stockInfo)
    }

    fun getStockInfo(stockSymbol: String, callback: (StockInfo?) -> Unit) = viewModelScope.launch {
        val stockInfo = repository.getStockInfo(stockSymbol)
        callback(stockInfo)
    }
}
