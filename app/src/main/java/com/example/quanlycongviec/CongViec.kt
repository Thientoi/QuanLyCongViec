package com.example.quanlycongviec

import java.io.Serializable

data class CongViec(
    var tenCongViec: String,
    var moTa: String,
    var trangThai: Boolean = false,
    var mucDoUuTien: String = "Trung bình"
) : Serializable {
    fun thongTin(): String =
        "Tên: $tenCongViec\nMô tả: $moTa\nTrạng thái: ${if (trangThai) "Đã hoàn thành" else "Chưa hoàn thành"}"
}
