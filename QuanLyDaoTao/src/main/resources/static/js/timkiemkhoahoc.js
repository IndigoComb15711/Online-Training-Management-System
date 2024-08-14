document.addEventListener('DOMContentLoaded', () => {
    // Tìm kiếm theo giảng viên
    document.getElementById("timKiemGiangVienForm").addEventListener("submit", function(event) {
        event.preventDefault();
        const maGV = document.getElementById("maGV").value;

        fetch(`/khoahoc/timkiem-theo-giangvien/${maGV}`)
            .then(response => response.json())
            .then(data => {
                let result = "<h4>Kết quả tìm kiếm:</h4>";
                if (data.length > 0) {
                    result += `
                        <table>
                            <thead>
                                <tr>
                                    <th>Mã Khóa Học</th>
                                    <th>Tên Khóa Học</th>
                                    <th>Thời Lượng</th>
                                    <th>Học Phí</th>
                                </tr>
                            </thead>
                            <tbody>`;

                    data.forEach(khoaHoc => {
                        result += `
                            <tr>
                                <td>${khoaHoc.maKH}</td>
                                <td>${khoaHoc.tenKH}</td>
                                <td>${khoaHoc.thoiLuong}</td>
                                <td>${khoaHoc.hocPhi}</td>
                            </tr>`;
                    });

                    result += `</tbody></table>`;
                } else {
                    result += "<p>Không tìm thấy khóa học nào.</p>";
                }
                document.getElementById("resultGiangVien").innerHTML = result;
            })
            .catch(error => {
                console.error('Lỗi:', error);
                document.getElementById("resultGiangVien").innerHTML = "<p>Đã xảy ra lỗi khi tìm kiếm khóa học theo giảng viên.</p>";
            });
    });

    // Tìm kiếm theo học phí
    document.getElementById("timKiemHocPhiForm").addEventListener("submit", function(event) {
        event.preventDefault();
        const hocPhiRange = document.getElementById("hocPhiRange").value;
        const [hocPhiMin, hocPhiMax] = hocPhiRange.split('-');

        fetch(`/khoahoc/timkiem-theo-hocphi/${hocPhiMin}/${hocPhiMax}`)
            .then(response => response.json())
            .then(data => {
                let result = "<h4>Kết quả tìm kiếm:</h4>";
                if (data.length > 0) {
                    result += `
                        <table>
                            <thead>
                                <tr>
                                    <th>Mã Khóa Học</th>
                                    <th>Tên Khóa Học</th>
                                    <th>Thời Lượng</th>
                                    <th>Học Phí</th>
                                </tr>
                            </thead>
                            <tbody>`;

                    data.forEach(khoaHoc => {
                        result += `
                            <tr>
                                <td>${khoaHoc.maKH}</td>
                                <td>${khoaHoc.tenKH}</td>
                                <td>${khoaHoc.thoiLuong}</td>
                                <td>${khoaHoc.hocPhi}</td>
                            </tr>`;
                    });

                    result += `</tbody></table>`;
                } else {
                    result += "<p>Không tìm thấy khóa học nào.</p>";
                }
                document.getElementById("resultHocPhi").innerHTML = result;
            })
            .catch(error => {
                console.error('Lỗi:', error);
                document.getElementById("resultHocPhi").innerHTML = "<p>Đã xảy ra lỗi khi tìm kiếm khóa học theo học phí.</p>";
            });
    });
});
