package com.example.quanlycongviec

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val cuon = ScrollView(this)
        val khung = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(36, 48, 36, 36)
        }
        val oTenCongViec = EditText(this).apply { hint = "Tên công việc" }
        val oMoTa = EditText(this).apply { hint = "Mô tả công việc" }
        cuon.addView(khung)
        setContentView(cuon)
        khung.addView(TextView(this).apply {
            text = "QUẢN LÝ CÔNG VIỆC CÁ NHÂN"
            textSize = 23f
        })
        khung.addView(TextView(this).apply {
            text = "Họ tên: HO TEN SINH VIEN\nMã sinh viên: MA SINH VIEN\nLớp HP: LOP HP"
            textSize = 17f
            setPadding(0, 24, 0, 24)
        })
        khung.addView(oTenCongViec)
        khung.addView(oMoTa)
        khung.addView(Button(this).apply {
            text = "Tạo công việc"
            setOnClickListener {
                val duLieu = Intent(this@MainActivity, ChiTietCongViecActivity::class.java)
                val congViec = CongViec(oTenCongViec.text.toString(), oMoTa.text.toString())
                duLieu.putExtra("congViec", congViec)
                startActivity(duLieu)
            }
        })
        khung.addView(Button(this).apply {
            text = "Xem danh sách công việc"
            setOnClickListener { Toast.makeText(this@MainActivity, "Danh sách đang trống", Toast.LENGTH_SHORT).show() }
        })
    }
}
