package com.example.quanlydaotao.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "KhoaHoc")
@Data
public class KhoaHoc {

    @Id
    @Column(name = "MaKH")
    private String maKH;

    @Column(name = "TenKH")
    private String tenKH;

    @Column(name = "MaGV")
    private String maGV;

    @Column(name = "ThoiLuong")
    private String thoiLuong;

    @Column(name = "HocPhi")
    private BigDecimal hocPhi;

    public KhoaHoc() {
    }

    public KhoaHoc(String maKH, String tenKH, String maGV, String thoiLuong, BigDecimal hocPhi) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.maGV = maGV;
        this.thoiLuong = thoiLuong;
        this.hocPhi = hocPhi;
    }

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

    public String getMaGV() {
        return maGV;
    }

    public void setMaGV(String maGV) {
        this.maGV = maGV;
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
}

