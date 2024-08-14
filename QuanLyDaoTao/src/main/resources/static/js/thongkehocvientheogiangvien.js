document.addEventListener('DOMContentLoaded', () => {
    const apiUrl = '/giangvien/thongke-hocvien/'; // Đặt đường dẫn API cơ bản
    const tableBody = document.querySelector('#student-table tbody');
    const giangvienSelect = document.getElementById('giangvien-select');

    // Hàm tải danh sách học viên theo giảng viên
    function loadStudents(maGV) {
        fetch(apiUrl + maGV)
            .then(response => response.json())
            .then(data => {
                tableBody.innerHTML = '';
                data.forEach(student => {
                    const row = tableBody.insertRow();
                    row.innerHTML = `
                        <td>${student.maHV}</td>
                        <td>${student.tenHV}</td>
                    `;
                });
            })
            .catch(error => {
                console.error('Lỗi khi tải danh sách học viên:', error);
                tableBody.innerHTML = '<tr><td colspan="2">Có lỗi xảy ra khi tải dữ liệu</td></tr>';
            });
    }

    // Nút "Hiển Thị"
    document.getElementById('btnDisplay').addEventListener('click', () => {
        const maGV = giangvienSelect.value;
        if (!maGV) {
            alert('Vui lòng chọn giảng viên.');
            return;
        }
        loadStudents(maGV);
    });
});
