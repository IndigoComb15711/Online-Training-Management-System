# Hệ thống Quản lý Đào tạo Trực tuyến

## Giới thiệu
Hệ thống Quản lý Đào tạo Trực tuyến là một ứng dụng được phát triển nhằm hỗ trợ các trung tâm đào tạo trực tuyến trong việc quản lý khóa học, học viên và giảng viên. Hệ thống cung cấp các chức năng quản lý thông tin, thống kê và báo cáo để tối ưu hóa quy trình đào tạo.

## Tính năng chính

### 1. Quản lý khóa học
- Lưu trữ, chỉnh sửa thông tin: Mã khóa học, tên khóa học, giảng viên phụ trách, thời lượng, học phí
- Tìm kiếm khóa học theo giảng viên và học phí
- Danh sách học viên đăng ký khóa học
- Danh sách học viên hoàn thành khóa học
- Khóa học phổ biến nhất

### 2. Quản lý giảng viên
- Lưu trữ, chỉnh sửa thông tin: Mã giảng viên, họ tên, chuyên môn, kinh nghiệm
- Quản lý lịch giảng dạy của giảng viên
- Thống kê số lượng học viên theo giảng viên
- Top 5 giảng viên có nhiều học viên nhất

### 3. Quản lý học viên
- Lưu trữ, chỉnh sửa thông tin: Mã học viên, họ tên, địa chỉ, số điện thoại, email
- Tính tổng số học viên đăng ký theo thời gian

## Cài đặt và Sử dụng

### Yêu cầu hệ thống
- Java Development Kit (JDK) 11 trở lên
- Maven 3.6 trở lên
- SQL Server 2019 trở lên
- MongoDB 4.4 trở lên
- Node.js 14 trở lên

### Cài đặt
1. Clone repository:
2. Cấu hình cơ sở dữ liệu:
- Tạo database trong SQL Server
- Cập nhật thông tin kết nối trong file `application.properties`
3. Cài đặt dependencies back-end:
mvn install

### Chạy ứng dụng
mvn spring-boot:run
Ứng dụng sẽ chạy tại `http://localhost:8080`

### Sử dụng
- Truy cập vào địa chỉ `http://localhost:8080`
- Đăng nhập với tài khoản mặc định:
- Username: admin
- Password: 123456
- Khám phá các tính năng của hệ thống thông qua menu chính

### API Documentation
API documentation có thể được truy cập tại `http://localhost:8080/swagger-ui.html` sau khi chạy ứng dụng.

## Công nghệ sử dụng
- Cơ sở dữ liệu (Database): Sử dụng SQL Server cho dữ liệu quan hệ.
- Sử dụng Java Spring Boot để xây dựng các API.
- Sử dụng HTML, CSS để xây dựng giao diện.

## Đóng góp
Chúng tôi rất hoan nghênh mọi đóng góp để cải thiện hệ thống. Nếu bạn muốn đóng góp, vui lòng tạo pull request hoặc báo cáo issues.

## Liên hệ
xx-xx-xx

## Giấy phép
