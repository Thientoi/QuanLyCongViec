package com.example.quanlycongviec

import org.junit.Assert.*
import org.junit.Test

class KiemThuCongViec {
    @Test fun kiemTraUuTienMacDinh() {
        val congViec = CongViec("Học Kotlin", "Bài tập")
        assertEquals("Trung bình", congViec.mucDoUuTien)
        congViec.mucDoUuTien = "Cao"
        assertEquals("Cao", congViec.mucDoUuTien)
    }
}
