# QuanLyCongViec - Bài thực hành Kotlin Android

Ứng dụng Android (Kotlin, View UI viết hoàn toàn bằng Kotlin, không dùng Jetpack Compose).

**Cần sửa trong** `MainActivity.kt`: `HO TEN SINH VIEN`, `MA SINH VIEN`, `LOP HP`.

Mở **thư mục gốc dự án** bằng Android Studio, chờ Gradle Sync rồi nhấn Run. Nếu Android Studio đề nghị cài Android SDK 35, chọn Install.

Branch: `cau1_activity`, `cau2_intent`, `cau3_activity_result`, `cau4_class_kotlin`, `cau5_kiem_thu`, `bo_sung_A`, `bo_sung_B`, `bo_sung_C`.

**Đề bổ sung:** lấy 3 chữ số cuối MSV chia 3. Dư 1 = A, dư 2 = B, dư 0 = C.

## Checklist kiểm tra Câu 5

1. Tạo công việc tên trống hoặc chỉ có dấu cách: hiển thị lỗi, không chuyển trang.
2. Nhập tên và mô tả hợp lệ: chuyển sang trang chi tiết.
3. Nhấn Chỉnh sửa, đổi tên và mô tả rồi Lưu: chi tiết cập nhật ngay.
4. Nhấn Đánh dấu hoàn thành: trạng thái chuyển sang Đã hoàn thành.
5. Quay lại và bấm Xem danh sách: thấy công việc đã cập nhật, mở lại vẫn đúng.

**Lưu ý**: Danh sách lưu trong RAM nên sẽ mất khi tắt hẳn app, đề không yêu cầu cơ sở dữ liệu.

> Ghi chú: project không có `gradlew.bat`/Gradle Wrapper JAR (để giữ ZIP nhỏ gọn). Bạn có thể mở nó trực tiếp bằng Android Studio và chọn sử dụng Gradle tích hợp/Generate Wrapper, hoặc chép thư mục `gradle/wrapper` và hai file `gradlew`, `gradlew.bat` từ một project Android Studio hiện có với Gradle 8.9.
