package com.example.quanlydaotao.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "LichGiangDay")
@Data
public class LichGiangDay {

    @Id
    @Column(name = "MaLich")
    private String maLich;

    @Column(name = "MaGV")
    private String maGV;

    @Column(name = "MaKH")
    private String maKH;

    @Column(name = "NgayGiangDay")
    private String ngayGiangDay;

    @Column(name = "KhungGio")
    private String khungGio;

    public LichGiangDay() {
    }

    public LichGiangDay(String maLich, String maGV, String maKH, String ngayGiangDay, String khungGio) {
        this.maLich = maLich;
        this.maGV = maGV;
        this.maKH = maKH;
        this.ngayGiangDay = ngayGiangDay;
        this.khungGio = khungGio;
    }

    public String getMaLich() {
        return maLich;
    }

    public void setMaLich(String maLich) {
        this.maLich = maLich;
    }

    public String getMaGV() {
        return maGV;
    }

    public void setMaGV(String maGV) {
        this.maGV = maGV;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getNgayGiangDay() {
        return ngayGiangDay;
    }

    public void setNgayGiangDay(String ngayGiangDay) {
        this.ngayGiangDay = ngayGiangDay;
    }

    public String getKhungGio() {
        return khungGio;
    }

    public void setKhungGio(String khungGio) {
        this.khungGio = khungGio;
    }
}


