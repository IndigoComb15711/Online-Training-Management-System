document.addEventListener('DOMContentLoaded', () => {
    const apiUrl = '/hocvien'; // Đặt đường dẫn API

    // Hàm hiển thị tổng số học viên đăng ký theo năm
    function loadStudentsByYear(year) {
        fetch(`${apiUrl}/tong-so-hoc-vien-dang-ky-theo-nam/${year}`)
            .then(response => response.json())
            .then(data => {
                const tableBody = document.querySelector('#year-table tbody');
                tableBody.innerHTML = '';
                data.forEach(item => {
                    const row = tableBody.insertRow();
                    row.innerHTML = `
                        <td>${item.thang}</td>
                        <td>${item.soHocVienDangKyThang}</td>
                        <td>${item.tongSoHocVienDangKyTichLuy}</td>
                    `;
                });
            })
            .catch(error => {
                console.error('Lỗi khi tải dữ liệu theo năm:', error);
                document.querySelector('#year-table tbody').innerHTML = '<tr><td colspan="3">Có lỗi xảy ra khi tải dữ liệu</td></tr>';
            });
    }

    // Hàm hiển thị tổng số học viên đăng ký theo tháng/năm
    function loadStudentsByMonthYear(month, year) {
        fetch(`${apiUrl}/tong-so-hoc-vien-dang-ky-theo-thang-nam/${month}/${year}`)
            .then(response => response.json())
            .then(data => {
                const tableBody = document.querySelector('#month-year-table tbody');
                tableBody.innerHTML = '';
                data.forEach(item => {
                    const row = tableBody.insertRow();
                    row.innerHTML = `
                        <td>${item.ngay}</td>
                        <td>${item.soHocVienDangKyNgay}</td>
                        <td>${item.tongSoHocVienDangKyTichLuy}</td>
                    `;
                });
            })
            .catch(error => {
                console.error('Lỗi khi tải dữ liệu theo tháng/năm:', error);
                document.querySelector('#month-year-table tbody').innerHTML = '<tr><td colspan="3">Có lỗi xảy ra khi tải dữ liệu</td></tr>';
            });
    }

    // Xử lý sự kiện khi nhấn nút "Hiển Thị" cho phần tổng số học viên đăng ký theo năm
    document.getElementById('btnYear').addEventListener('click', () => {
        const year = document.getElementById('year-select').value;
        if (year) {
            loadStudentsByYear(year);
        } else {
            alert('Vui lòng chọn năm.');
        }
    });

    // Xử lý sự kiện khi nhấn nút "Hiển Thị" cho phần tổng số học viên đăng ký theo tháng/năm
    document.getElementById('btnMonthYear').addEventListener('click', () => {
        const month = document.getElementById('month-select').value;
        const year = document.getElementById('month-year-select').value;
        if (month && year) {
            loadStudentsByMonthYear(month, year);
        } else {
            alert('Vui lòng chọn tháng và năm.');
        }
    });
});
