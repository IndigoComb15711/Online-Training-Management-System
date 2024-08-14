document.addEventListener('DOMContentLoaded', () => {
    const tableBody = document.querySelector('#course-table tbody');
    const apiUrl = '/khoahoc';

    // Hàm tải danh sách khóa học
    function loadCourses() {
        fetch(apiUrl)
            .then(response => response.json())
            .then(data => {
                tableBody.innerHTML = '';
                data.forEach(course => {
                    const row = tableBody.insertRow();
                    row.innerHTML = `
                        <td>${course.maKH}</td>
                        <td>${course.tenKH}</td>
                        <td>${course.maGV}</td>
                        <td>${course.thoiLuong}</td>
                        <td>${formatCurrency(course.hocPhi)}</td>
                    `;
                });
            })
            .catch(error => {
                console.error('Lỗi khi tải danh sách khóa học:', error);
                tableBody.innerHTML = '<tr><td colspan="5">Có lỗi xảy ra khi tải dữ liệu</td></tr>';
            });
    }

    // Định dạng học phí thành kiểu tiền tệ
    function formatCurrency(value) {
        return new Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND' }).format(value);
    }

    // Thêm khóa học
    document.getElementById('btnCreate').addEventListener('click', () => {
        const maKH = document.getElementById('maKH').value;
        const maGV = document.getElementById('maGV').value;

        if (!maKH || !maGV) {
            alert('Vui lòng nhập mã khóa học và mã giảng viên.');
            return;
        }

        const newCourse = {
            maKH: maKH,
            tenKH: document.getElementById('tenKH').value,
            maGV: maGV,
            thoiLuong: document.getElementById('thoiLuong').value,
            hocPhi: parseFloat(document.getElementById('hocPhi').value.replace(/[.,₫]/g, ''))
        };

        fetch(apiUrl, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(newCourse)
        })
            .then(response => {
                if (response.ok) {
                    return response.json();
                } else if (response.status === 404) {
                    throw new Error('Mã giảng viên không tồn tại.');
                } else {
                    throw new Error('Lỗi khi thêm khóa học.');
                }
            })
            .then(() => loadCourses())
            .catch(error => alert(`Lỗi: ${error.message}`));
    });

    // Hiển thị danh sách khóa học
    document.getElementById('btnDisplay').addEventListener('click', loadCourses);

    // Cập nhật khóa học
    document.getElementById('btnUpdate').addEventListener('click', () => {
        const maKH = document.getElementById('maKH').value;

        if (!maKH) {
            alert('Vui lòng nhập mã khóa học.');
            return;
        }

        const updatedCourse = {
            tenKH: document.getElementById('tenKH').value,
            maGV: document.getElementById('maGV').value,
            thoiLuong: document.getElementById('thoiLuong').value,
            hocPhi: parseFloat(document.getElementById('hocPhi').value.replace(/[.,₫]/g, ''))
        };

        fetch(`${apiUrl}/${maKH}`, {
            method: 'PUT',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(updatedCourse)
        })
            .then(response => {
                if (response.ok) {
                    return response.json();
                } else {
                    throw new Error('Lỗi khi cập nhật khóa học.');
                }
            })
            .then(() => loadCourses())
            .catch(error => alert(`Lỗi: ${error.message}`));
    });

    // Xóa khóa học
    document.getElementById('btnDelete').addEventListener('click', () => {
        const maKH = document.getElementById('maKH').value;

        if (!maKH) {
            alert('Vui lòng nhập mã khóa học.');
            return;
        }

        fetch(`${apiUrl}/${maKH}`, {
            method: 'DELETE'
        })
            .then(response => {
                if (response.ok) {
                    return;
                } else {
                    throw new Error('Lỗi khi xóa khóa học.');
                }
            })
            .then(() => loadCourses())
            .catch(error => alert(`Lỗi: ${error.message}`));
    });
});
