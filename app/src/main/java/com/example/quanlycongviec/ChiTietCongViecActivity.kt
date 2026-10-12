package com.example.quanlycongviec

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.ComponentActivity

class ChiTietCongViecActivity : ComponentActivity() {
    private lateinit var khung: LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        khung = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(36, 48, 36, 36)
        }
        setContentView(khung)
        khung.addView(TextView(this).apply { text = "CHI TIẾT CÔNG VIỆC"; textSize = 24f })
        khung.addView(TextView(this).apply {
            text = "Tên: ${intent.getStringExtra("tenCongViec").orEmpty()}"
            textSize = 19f
        })
        khung.addView(TextView(this).apply {
            text = "Mô tả: ${intent.getStringExtra("moTa").orEmpty()}"
            textSize = 18f
        })
    }
}
