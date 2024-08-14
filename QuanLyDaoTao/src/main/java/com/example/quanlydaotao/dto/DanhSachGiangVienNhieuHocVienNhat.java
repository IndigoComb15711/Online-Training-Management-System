package com.example.quanlydaotao.dto;

public class DanhSachGiangVienNhieuHocVienNhat {
    private String maGV;
    private String tenGV;
    private String tenKH;
    private Long soLuongHocVien;

    public String getMaGV() {
        return maGV;
    }

    public void setMaGV(String maGV) {
        this.maGV = maGV;
    }

    public String getTenGV() {
        return tenGV;
    }

    public void setTenGV(String tenGV) {
        this.tenGV = tenGV;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public Long getSoLuongHocVien() {
        return soLuongHocVien;
    }

    public void setSoLuongHocVien(Long soLuongHocVien) {
        this.soLuongHocVien = soLuongHocVien;
    }
}
