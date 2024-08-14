document.addEventListener('DOMContentLoaded', () => {
    const tableBody = document.querySelector('#student-table tbody');
    const apiUrl = '/hocvien'; // Đặt đường dẫn API

    // Hàm tải danh sách học viên
    function loadStudents() {
        fetch(apiUrl)
            .then(response => response.json())
            .then(data => {
                tableBody.innerHTML = '';
                data.forEach(student => {
                    const row = tableBody.insertRow();
                    row.innerHTML = `
                        <td>${student.maHV}</td>
                        <td>${student.tenHV}</td>
                        <td>${student.diaChi}</td>
                        <td>${student.sdt}</td>
                        <td>${student.email}</td>
                    `;
                });
            })
            .catch(error => {
                console.error('Lỗi khi tải danh sách học viên:', error);
                tableBody.innerHTML = '<tr><td colspan="5">Có lỗi xảy ra khi tải dữ liệu</td></tr>';
            });
    }

    // Thêm học viên
    document.getElementById('btnCreate').addEventListener('click', () => {
        const maHV = document.getElementById('maHV').value;
        if (!maHV) {
            alert('Vui lòng nhập mã học viên.');
            return;
        }
        const newStudent = {
            maHV: maHV,
            tenHV: document.getElementById('tenHV').value,
            diaChi: document.getElementById('diaChi').value,
            sdt: document.getElementById('sdt').value,
            email: document.getElementById('email').value
        };

        fetch(apiUrl, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(newStudent)
        })
            .then(response => response.json())
            .then(() => loadStudents())
            .catch(error => console.error('Lỗi:', error));
    });

    // Hiển thị danh sách học viên
    document.getElementById('btnDisplay').addEventListener('click', () => {
        loadStudents();
    });

    // Cập nhật học viên
    document.getElementById('btnUpdate').addEventListener('click', () => {
        const maHV = document.getElementById('maHV').value;
        if (!maHV) {
            alert('Vui lòng nhập mã học viên.');
            return;
        }
        const updatedStudent = {
            tenHV: document.getElementById('tenHV').value,
            diaChi: document.getElementById('diaChi').value,
            sdt: document.getElementById('sdt').value,
            email: document.getElementById('email').value
        };

        fetch(`${apiUrl}/${maHV}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(updatedStudent)
        })
            .then(response => response.json())
            .then(() => loadStudents())
            .catch(error => console.error('Lỗi:', error));
    });

    // Xóa học viên
    document.getElementById('btnDelete').addEventListener('click', () => {
        const maHV = document.getElementById('maHV').value;
        if (!maHV) {
            alert('Vui lòng nhập mã học viên.');
            return;
        }

        fetch(`${apiUrl}/${maHV}`, {
            method: 'DELETE'
        })
            .then(() => loadStudents())
            .catch(error => console.error('Lỗi:', error));
    });
});
