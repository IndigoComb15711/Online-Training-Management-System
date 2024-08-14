package com.example.quanlydaotao.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import lombok.Data;
import java.sql.Date;

@Entity
@Table(name = "DangKy")
@Data
public class DangKy {

    @Id
    @Column(name = "MaDK")
    private String maDK;

    @Column(name = "MaHV")
    private String maHV;

    @Column(name = "MaKH")
    private String maKH;

    @Column(name = "TinhTrangDK")
    private String tinhTrangDK;

    @Column(name = "NgayDK")
    private Date ngayDK;

    public DangKy() {
    }

    public DangKy(String maDK, String maHV, String maKH, String tinhTrangDK, Date ngayDK) {
        this.maDK = maDK;
        this.maHV = maHV;
        this.maKH = maKH;
        this.tinhTrangDK = tinhTrangDK;
        this.ngayDK = ngayDK;
    }

    public String getMaDK() {
        return maDK;
    }

    public void setMaDK(String maDK) {
        this.maDK = maDK;
    }

    public String getMaHV() {
        return maHV;
    }

    public void setMaHV(String maHV) {
        this.maHV = maHV;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getTinhTrangDK() {
        return tinhTrangDK;
    }

    public void setTinhTrangDK(String tinhTrangDK) {
        this.tinhTrangDK = tinhTrangDK;
    }

    public Date getNgayDK() {
        return ngayDK;
    }

    public void setNgayDK(Date ngayDK) {
        this.ngayDK = ngayDK;
    }
}

