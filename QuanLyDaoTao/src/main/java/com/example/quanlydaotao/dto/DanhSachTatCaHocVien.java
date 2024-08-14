package com.example.quanlydaotao.dto;

import java.sql.Date;

public class DanhSachTatCaHocVien {
    private String maKH;
    private String tenKH;
    private String maHV;
    private String tenHV;
    private Date ngayDK;
    private String tinhTrangDK;

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

    public String getMaHV() {
        return maHV;
    }

    public void setMaHV(String maHV) {
        this.maHV = maHV;
    }

    public String getTenHV() {
        return tenHV;
    }

    public void setTenHV(String tenHV) {
        this.tenHV = tenHV;
    }

    public Date getNgayDK() {
        return ngayDK;
    }

    public void setNgayDK(Date ngayDK) {
        this.ngayDK = ngayDK;
    }

    public String getTinhTrangDK() {
        return tinhTrangDK;
    }

    public void setTinhTrangDK(String tinhTrangDK) {
        this.tinhTrangDK = tinhTrangDK;
    }
}
