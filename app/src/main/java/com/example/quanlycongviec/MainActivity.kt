package com.example.quanlycongviec

import android.app.AlertDialog
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContracts
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    private val danhSachCongViec = mutableListOf<CongViec>()
    private val moChiTiet = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { ketQua ->
        if (ketQua.resultCode == RESULT_OK) {
            val congViec = ketQua.data?.getSerializableExtra("congViec") as? CongViec
            val viTri = ketQua.data?.getIntExtra("viTriCongViec", -1) ?: -1
            if (congViec != null && viTri in danhSachCongViec.indices) {
                danhSachCongViec[viTri] = congViec
            }
        }
    }

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
                val ten = oTenCongViec.text.toString().trim()
                if (ten.isEmpty()) {
                    oTenCongViec.error = "Không được để trống tên công việc"
                    oTenCongViec.requestFocus()
                    return@setOnClickListener
                }
                val duLieu = Intent(this@MainActivity, ChiTietCongViecActivity::class.java)
                val congViec = CongViec(ten, oMoTa.text.toString().trim())
                danhSachCongViec.add(congViec)
                duLieu.putExtra("congViec", congViec)
                duLieu.putExtra("viTriCongViec", danhSachCongViec.lastIndex)
                moChiTiet.launch(duLieu)
            }
        })
        khung.addView(Button(this).apply {
            text = "Xem danh sách công việc"
            setOnClickListener {
                if (danhSachCongViec.isEmpty()) {
                    Toast.makeText(this@MainActivity, "Danh sách đang trống", Toast.LENGTH_SHORT).show()
                } else {
                    val tenCongViec = danhSachCongViec.map {
                        "${it.tenCongViec} — ${if (it.trangThai) "Đã hoàn thành" else "Chưa hoàn thành"}"
                    }.toTypedArray()
                    AlertDialog.Builder(this@MainActivity)
                        .setTitle("Danh sách công việc")
                        .setItems(tenCongViec) { _, viTri ->
                            moChiTiet.launch(
                                Intent(this@MainActivity, ChiTietCongViecActivity::class.java).apply {
                                    putExtra("congViec", danhSachCongViec[viTri])
                                    putExtra("viTriCongViec", viTri)
                                }
                            )
                        }
                        .setNegativeButton("Đóng", null)
                        .show()
                }
            }
        })
    }
}
