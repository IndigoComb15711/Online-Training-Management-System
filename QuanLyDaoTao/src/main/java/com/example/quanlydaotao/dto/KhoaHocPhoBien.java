package com.example.quanlydaotao.dto;

import java.math.BigDecimal;

public class KhoaHocPhoBien {
    private String maKH;
    private String tenKH;
    private String tenGiangVien;
    private String thoiLuong;
    private BigDecimal hocPhi; // Sử dụng BigDecimal cho kiểu DECIMAL
    private Long soLuongHocVien;

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getTenGiangVien() {
        return tenGiangVien;
    }

    public void setTenGiangVien(String tenGiangVien) {
        this.tenGiangVien = tenGiangVien;
    }

    public String getThoiLuong() {
        return thoiLuong;
    }

    public void setThoiLuong(String thoiLuong) {
        this.thoiLuong = thoiLuong;
    }

    public BigDecimal getHocPhi() {
        return hocPhi;
    }

    public void setHocPhi(BigDecimal hocPhi) {
        this.hocPhi = hocPhi;
    }

    public Long getSoLuongHocVien() {
        return soLuongHocVien;
    }

    public void setSoLuongHocVien(Long soLuongHocVien) {
        this.soLuongHocVien = soLuongHocVien;
    }
}

