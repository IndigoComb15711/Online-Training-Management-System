        document.addEventListener('DOMContentLoaded', () => {
            const allStudentsTableBody = document.querySelector('#student-table tbody');
            const studentsByCourseTableBody = document.querySelector('#student-table-by-course tbody');
            const apiUrl = '/khoahoc'; // Đặt đường dẫn API chung
            const courseSelect = document.getElementById('course-select');

            // Hàm tải danh sách tất cả học viên
            function loadAllStudents() {
                fetch(`${apiUrl}/danhsach-hvhtkh`)
                    .then(response => response.json())
                    .then(data => {
                        allStudentsTableBody.innerHTML = '';
                        data.forEach(student => {
                            const row = allStudentsTableBody.insertRow();
                            row.innerHTML = `
                                <td>${student.maHV}</td>
                                <td>${student.tenHV}</td>
                                <td>${student.diaChi}</td>
                                <td>${student.sdt}</td>
                            `;
                        });
                    })
                    .catch(error => {
                        console.error('Lỗi khi tải danh sách học viên:', error);
                        allStudentsTableBody.innerHTML = '<tr><td colspan="4">Có lỗi xảy ra khi tải dữ liệu</td></tr>';
                    });
            }

            // Hàm tải danh sách học viên theo khóa học
            function loadStudentsByCourse() {
                const maKH = document.getElementById('course-select').value;
                if (!maKH) {
                    alert('Vui lòng chọn khóa học.');
                    return;
                }
                fetch(`${apiUrl}/danhsach-hvhtkh-theo/${maKH}`)
                    .then(response => response.json())
                    .then(data => {
                        studentsByCourseTableBody.innerHTML = '';
                        data.forEach(student => {
                            const row = studentsByCourseTableBody.insertRow();
                            row.innerHTML = `
                                <td>${student.maHV}</td>
                                <td>${student.tenHV}</td>
                                <td>${student.diaChi}</td>
                                <td>${student.sdt}</td>
                            `;
                        });
                    })
                    .catch(error => {
                        console.error('Lỗi khi tải danh sách học viên theo khóa học:', error);
                        studentsByCourseTableBody.innerHTML = '<tr><td colspan="4">Có lỗi xảy ra khi tải dữ liệu</td></tr>';
                    });
            }

            // Nút "Danh Sách Tất Cả Học Viên"
            document.getElementById('btnAllStudents').addEventListener('click', () => {
                loadAllStudents();
            });

            // Nút "Danh Sách Học Viên Theo Khóa Học"
            document.getElementById('btnStudentsByCourse').addEventListener('click', () => {
                loadStudentsByCourse();
            });

            // Tải danh sách khóa học vào dropdown
            function loadCourses() {

                const courses = Array.from({ length: 13 }, (_, i) => ({
                    maKH: `KH${String(i + 1).padStart(2, '0')}`,
                    tenKH: `Khóa Học ${String(i + 1).padStart(2, '0')}`
                }));
                courses.forEach(course => {
                    const option = document.createElement('option');
                    option.value = course.maKH;
                    option.textContent = course.tenKH;
                    courseSelect.appendChild(option);
                });
            }

            // Tải danh sách khóa học khi trang được tải
            loadCourses();
        });
