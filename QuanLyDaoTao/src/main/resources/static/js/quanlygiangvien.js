document.addEventListener('DOMContentLoaded', () => {
    const tableBody = document.querySelector('#teacher-table tbody');
    const apiUrl = '/giangvien'; // Đặt đường dẫn API

    // Hàm tải danh sách giảng viên
    function loadTeachers() {
        fetch(apiUrl)
            .then(response => response.json())
            .then(data => {
                tableBody.innerHTML = '';
                data.forEach(teacher => {
                    const row = tableBody.insertRow();
                    row.innerHTML = `
                        <td>${teacher.maGV}</td>
                        <td>${teacher.tenGV}</td>
                        <td>${teacher.chuyenMon}</td>
                        <td>${teacher.kinhNghiem}</td>
                    `;
                });
            })
            .catch(error => {
                console.error('Lỗi khi tải danh sách giảng viên:', error);
                tableBody.innerHTML = '<tr><td colspan="4">Có lỗi xảy ra khi tải dữ liệu</td></tr>';
            });
    }

    // Thêm giảng viên
    document.getElementById('btnCreate').addEventListener('click', () => {
        const maGV = document.getElementById('maGV').value;
        if (!maGV) {
            alert('Vui lòng nhập mã giảng viên.');
            return;
        }
        const newTeacher = {
            maGV: maGV,
            tenGV: document.getElementById('tenGV').value,
            chuyenMon: document.getElementById('chuyenMon').value,
            kinhNghiem: document.getElementById('kinhNghiem').value
        };

        fetch(apiUrl, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(newTeacher)
        })
            .then(response => response.json())
            .then(() => loadTeachers())
            .catch(error => console.error('Lỗi:', error));
    });

    // Hiển thị danh sách giảng viên
    document.getElementById('btnDisplay').addEventListener('click', () => {
        loadTeachers();
    });

    // Cập nhật giảng viên
    document.getElementById('btnUpdate').addEventListener('click', () => {
        const maGV = document.getElementById('maGV').value;
        if (!maGV) {
            alert('Vui lòng nhập mã giảng viên.');
            return;
        }
        const updatedTeacher = {
            tenGV: document.getElementById('tenGV').value,
            chuyenMon: document.getElementById('chuyenMon').value,
            kinhNghiem: document.getElementById('kinhNghiem').value
        };

        fetch(`${apiUrl}/${maGV}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(updatedTeacher)
        })
            .then(response => response.json())
            .then(() => loadTeachers())
            .catch(error => console.error('Lỗi:', error));
    });

    // Xóa giảng viên
    document.getElementById('btnDelete').addEventListener('click', () => {
        const maGV = document.getElementById('maGV').value;
        if (!maGV) {
            alert('Vui lòng nhập mã giảng viên.');
            return;
        }

        fetch(`${apiUrl}/${maGV}`, {
            method: 'DELETE'
        })
            .then(() => loadTeachers())
            .catch(error => console.error('Lỗi:', error));
    });
});
