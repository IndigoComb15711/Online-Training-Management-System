document.addEventListener('DOMContentLoaded', () => {
    const apiUrl = '/giangvien/giang-vien-nhieu-hoc-vien-nhat';

    function loadTop5Instructors() {
        fetch(apiUrl)
            .then(response => response.json())
            .then(data => {
                const tableBody = document.querySelector('#top5-table tbody');
                tableBody.innerHTML = '';
                data.forEach(instructor => {
                    const row = tableBody.insertRow();
                    row.innerHTML = `
                        <td>${instructor.maGV}</td>
                        <td>${instructor.tenGV}</td>
                        <td>${instructor.tenKH}</td>
                        <td>${instructor.soLuongHocVien}</td>
                    `;
                });
            })
            .catch(error => {
                console.error('Lỗi khi tải danh sách giảng viên:', error);
                const tableBody = document.querySelector('#top5-table tbody');
                tableBody.innerHTML = '<tr><td colspan="4">Có lỗi xảy ra khi tải dữ liệu</td></tr>';
            });
    }

    loadTop5Instructors();
});
