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
    private lateinit var hienTrangThai: TextView
    private lateinit var hienUuTien: TextView
    private lateinit var congViec: CongViec
    private val nhanKetQuaChinhSua = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { ketQua ->
        if (ketQua.resultCode == RESULT_OK) {
            val congViecDaSua = ketQua.data?.getSerializableExtra("congViec") as? CongViec
            if (congViecDaSua != null) {
                congViec = congViecDaSua
                hienTen.text = "Tên: ${congViec.tenCongViec}"
                hienMoTa.text = "Mô tả: ${congViec.moTa}"
                hienUuTien.text = "Ưu tiên: ${congViec.mucDoUuTien}"
                hienTrangThai.text = "Trạng thái: ${if (congViec.trangThai) "Đã hoàn thành" else "Chưa hoàn thành"}"
                capNhatKetQuaChoMain()
            }
        }
    }
    private fun capNhatKetQuaChoMain() {
        setResult(RESULT_OK, Intent().apply {
            putExtra("congViec", congViec)
            putExtra("viTriCongViec", intent.getIntExtra("viTriCongViec", -1))
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        khung = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(36, 48, 36, 36)
        }
        setContentView(khung)
        khung.addView(TextView(this).apply { text = "CHI TIẾT CÔNG VIỆC"; textSize = 24f })
        congViec = (intent.getSerializableExtra("congViec") as? CongViec)
            ?: CongViec("", "")
        hienTen = TextView(this).apply { text = "Tên: ${congViec.tenCongViec}"; textSize = 19f }
        hienMoTa = TextView(this).apply { text = "Mô tả: ${congViec.moTa}"; textSize = 18f }
        khung.addView(hienTen)
        khung.addView(hienMoTa)
        hienUuTien = TextView(this).apply {
            text = "Ưu tiên: ${congViec.mucDoUuTien}"
            textSize = 18f
        }
        khung.addView(hienUuTien)
        hienTrangThai = TextView(this).apply { textSize = 18f }
        khung.addView(hienTrangThai)
        hienTrangThai.text = "Trạng thái: ${if (congViec.trangThai) "Đã hoàn thành" else "Chưa hoàn thành"}"
        capNhatKetQuaChoMain()
        khung.addView(Button(this).apply {
            text = "Đánh dấu hoàn thành"
            setOnClickListener {
                congViec.trangThai = true
                hienTrangThai.text = "Trạng thái: Đã hoàn thành"
                capNhatKetQuaChoMain()
            }
        })
        khung.addView(Button(this).apply {
            text = "Chỉnh sửa"
            setOnClickListener {
                val duLieu = Intent(this@ChiTietCongViecActivity, ChinhSuaCongViecActivity::class.java)
                duLieu.putExtra("congViec", congViec)
                nhanKetQuaChinhSua.launch(duLieu)
            }
        })
    }
}
