package com.example.quanlydaotao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TrangChuController {

    @GetMapping("/")
    public String trangchu() {
        return "trangchu";
    }
    @GetMapping("/trang-chu")
    public String home() {
        return "trangchu";
    }
    @GetMapping("/quan-ly-khoa-hoc")
    public String quanLyThongTinKhoaHoc() {
        return "quanlykhoahoc";
    }
    @GetMapping("/tim-kiem-khoa-hoc")
    public String timKiemKhoaHoc() {
        return "timkiemkhoahoc";
    }
    @GetMapping("/danh-sach-hoc-vien-dang-ky")
    public String danhSachHocVienDangKy() {
        return "danhsachhocviendangky";
    }
    @GetMapping("/danh-sach-hvhtkh")
    public String danhSachHVHTKH() {
        return "danhsachhvhtkh";
    }
    @GetMapping("/quan-ly-giang-vien")
    public String quanLyThongTinGiangVien() {
        return "quanlygiangvien";
    }
    @GetMapping("/lich-giang-day")
    public String lichGiangDay() {
        return "lichgiangday";
    }
    @GetMapping("/thong-ke-hoc-vien-theo-giang-vien")
    public String thongKeHocVien() {
        return "thongkehocvientheogiangvien";
    }
    @GetMapping("/top-5-giang-vien")
    public String top5GiangVien() {
        return "top5giangvien";
    }
    @GetMapping("/quan-ly-hoc-vien")
    public String quanLyThongTinHocVien() {
        return "quanlyhocvien";
    }
    @GetMapping("/tong-so-hoc-vien-dang-ky-theo-thoi-gian")
    public String tongSoHocVienDangKyTheoThoiGian() {
        return "tongsohocviendangkytheothoigian";
    }
}
