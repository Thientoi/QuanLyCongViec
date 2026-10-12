package com.example.quanlycongviec

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.ComponentActivity

class ChinhSuaCongViecActivity : ComponentActivity() {
    private lateinit var oTen: EditText
    private lateinit var oMoTa: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val khung = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(36, 48, 36, 36)
        }
        setContentView(khung)
        khung.addView(TextView(this).apply { text = "CHỈNH SỬA CÔNG VIỆC"; textSize = 24f })
        oTen = EditText(this).apply {
            hint = "Tên công việc"
            setText((intent.getSerializableExtra("congViec") as? CongViec)?.tenCongViec.orEmpty())
        }
        oMoTa = EditText(this).apply {
            hint = "Mô tả công việc"
            setText((intent.getSerializableExtra("congViec") as? CongViec)?.moTa.orEmpty())
        }
        khung.addView(oTen)
        khung.addView(oMoTa)
        khung.addView(Button(this).apply {
            text = "Lưu"
            setOnClickListener {
                val ten = oTen.text.toString().trim()
                if (ten.isEmpty()) {
                    oTen.error = "Tên công việc không được để trống"
                    oTen.requestFocus()
                    return@setOnClickListener
                }
                val ketQua = Intent()
                val congViec = (intent.getSerializableExtra("congViec") as? CongViec)
                    ?: CongViec("", "")
                congViec.tenCongViec = ten
                congViec.moTa = oMoTa.text.toString()
                ketQua.putExtra("congViec", congViec)
                setResult(RESULT_OK, ketQua)
                finish()
            }
        })
    }
}
