document.addEventListener('DOMContentLoaded', function() {
    function fetchAllStudents() {
        fetch('/khoahoc/danhsach-hocvien-dangky')
            .then(response => response.json())
            .then(data => {
                const tableBody = document.getElementById('student-list');
                tableBody.innerHTML = '';

                data.forEach(student => {
                    const row = document.createElement('tr');
                    row.innerHTML = `
                        <td>${student.maKH}</td>
                        <td>${student.tenKH}</td>
                        <td>${student.maHV}</td>
                        <td>${student.tenHV}</td>
                        <td>${student.ngayDK}</td>
                        <td>${student.tinhTrangDK}</td>
                    `;
                    tableBody.appendChild(row);
                });
            })
            .catch(error => console.error('Error loading all students:', error));
    }

    function fetchStudentsByCourse() {
        const courseId = document.getElementById('course-select').value;
        if (!courseId) {
            alert('Vui lòng chọn mã khóa học.');
            return;
        }

        fetch(`/khoahoc/danhsach-hocvien-dangky-theo/${courseId}`)
            .then(response => response.json())
            .then(data => {
                const tableBody = document.getElementById('course-student-list');
                tableBody.innerHTML = '';

                data.forEach(student => {
                    const row = document.createElement('tr');
                    row.innerHTML = `
                        <td>${student.maKH}</td>
                        <td>${student.tenKH}</td>
                        <td>${student.maHV}</td>
                        <td>${student.tenHV}</td>
                        <td>${student.ngayDK}</td>
                        <td>${student.tinhTrangDK}</td>
                    `;
                    tableBody.appendChild(row);
                });
            })
            .catch(error => console.error('Error searching students by course:', error));
    }

    document.querySelector('button[onclick="fetchAllStudents()"]').addEventListener('click', fetchAllStudents);
    document.querySelector('button[onclick="fetchStudentsByCourse()"]').addEventListener('click', fetchStudentsByCourse);
});
