document.addEventListener('DOMContentLoaded', () => {
    const tableBody = document.querySelector('#schedule-table tbody');
    const apiUrl = '/giangvien/lich-giang-day'; // Đặt đường dẫn API

    // Hàm tải danh sách lịch giảng dạy
    function loadSchedules() {
        fetch(apiUrl)
            .then(response => response.json())
            .then(data => {
                tableBody.innerHTML = '';
                data.forEach(schedule => {
                    const row = tableBody.insertRow();
                    row.innerHTML = `
                        <td>${schedule.maLich}</td>
                        <td>${schedule.maGV}</td>
                        <td>${schedule.tenGV}</td>
                        <td>${schedule.maKH}</td>
                        <td>${schedule.tenKH}</td>
                        <td>${schedule.ngayGiangDay}</td>
                        <td>${schedule.khungGio}</td>
                    `;
                });
            })
            .catch(error => {
                console.error('Lỗi khi tải lịch giảng dạy:', error);
                tableBody.innerHTML = '<tr><td colspan="7">Có lỗi xảy ra khi tải dữ liệu</td></tr>';
            });
    }

    // Tải lịch giảng dạy khi trang được tải
    loadSchedules();
});
