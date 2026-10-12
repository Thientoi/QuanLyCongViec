package com.example.quanlycongviec

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.result.contract.ActivityResultContracts
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.ComponentActivity

class ChiTietCongViecActivity : ComponentActivity() {
    private lateinit var khung: LinearLayout
    private lateinit var hienTen: TextView
    private lateinit var hienMoTa: TextView
    private var tenCongViec = ""
    private var moTa = ""
    private val nhanKetQuaChinhSua = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { /* cap nhat giao dien o commit tiep theo */ }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        khung = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(36, 48, 36, 36)
        }
        setContentView(khung)
        khung.addView(TextView(this).apply { text = "CHI TIẾT CÔNG VIỆC"; textSize = 24f })
        tenCongViec = intent.getStringExtra("tenCongViec").orEmpty()
        moTa = intent.getStringExtra("moTa").orEmpty()
        hienTen = TextView(this).apply { text = "Tên: $tenCongViec"; textSize = 19f }
        hienMoTa = TextView(this).apply { text = "Mô tả: $moTa"; textSize = 18f }
        khung.addView(hienTen)
        khung.addView(hienMoTa)
        khung.addView(Button(this).apply {
            text = "Chỉnh sửa"
            setOnClickListener {
                val duLieu = Intent(this@ChiTietCongViecActivity, ChinhSuaCongViecActivity::class.java)
                duLieu.putExtra("tenCongViec", tenCongViec)
                duLieu.putExtra("moTa", moTa)
                nhanKetQuaChinhSua.launch(duLieu)
            }
        })
    }
}
