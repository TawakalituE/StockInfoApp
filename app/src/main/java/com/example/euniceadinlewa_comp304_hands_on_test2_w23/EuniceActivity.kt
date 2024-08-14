package com.example.euniceadinlewa_comp304_hands_on_test2_w23

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

class EuniceActivity : AppCompatActivity() {

    private lateinit var stockInfoViewModel: StockInfoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eunice)

        supportActionBar?.title = "EuniceAdinlewa_COMP304_Hands-On_Test2_W23"

        stockInfoViewModel = ViewModelProvider(this).get(StockInfoViewModel::class.java)

        val insertButton: Button = findViewById(R.id.insertButton)
        val displayButton: Button = findViewById(R.id.displayButton)
        val radioGroup: RadioGroup = findViewById(R.id.radioGroup)
        val stockInfoTextView: TextView = findViewById(R.id.stockInfoTextView)

        insertButton.setOnClickListener {
            insertStocks()
        }

        displayButton.setOnClickListener {
            val selectedRadioButtonId = radioGroup.checkedRadioButtonId
            if (selectedRadioButtonId != -1) {
                val selectedRadioButton: RadioButton = findViewById(selectedRadioButtonId)
                val stockSymbol = selectedRadioButton.text.toString()
                stockInfoViewModel.getStockInfo(stockSymbol) { stockInfo ->
                    if (stockInfo != null) {
                        stockInfoTextView.text = "Company Name: ${stockInfo.companyName}\nStock Quote: ${stockInfo.stockQuote}"
                        sendBroadcast(stockInfo)
                    } else {
                        Toast.makeText(this, "Stock info not found", Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                Toast.makeText(this, "Please select a stock symbol", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun insertStocks() {
        val stock1 = StockInfo("GOOGL", "Google", 2800.0)
        val stock2 = StockInfo("AMZN", "Amazon", 990.0)
        stockInfoViewModel.insert(stock1)
        stockInfoViewModel.insert(stock2)
        Toast.makeText(this, "Stocks inserted", Toast.LENGTH_SHORT).show()
    }

    private fun sendBroadcast(stockInfo: StockInfo) {

        val formattedText = "Stock Info received:\nCompany Name: ${stockInfo.companyName}\nStock Quote: ${stockInfo.stockQuote}"

        val intent = Intent(this, StockInfoReceiver::class.java).apply {
            putExtra("stock_info", formattedText)
        }
        sendBroadcast(intent)
    }

}
