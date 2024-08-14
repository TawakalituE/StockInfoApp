package com.example.euniceadinlewa_comp304_hands_on_test2_w23

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import android.widget.Toast

class StockInfoReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val stockInfo = intent?.getStringExtra("stock_info")
        if (context != null && stockInfo != null) {

            val inflater = LayoutInflater.from(context)
            val layout: View = inflater.inflate(R.layout.activity_custom_toast, null)

            val toastTextView: TextView = layout.findViewById(R.id.toastTextView)
            toastTextView.text = stockInfo

            with (Toast(context)) {
                duration = Toast.LENGTH_LONG
                view = layout
                show()
            }
        }
    }
}
