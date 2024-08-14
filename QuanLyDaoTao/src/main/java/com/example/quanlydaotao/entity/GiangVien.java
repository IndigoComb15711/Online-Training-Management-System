package com.example.quanlydaotao.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "GiangVien")
@Data
public class GiangVien {

    @Id
    @Column(name = "MaGV")
    private String maGV;

    @Column(name = "TenGV")
    private String tenGV;

    @Column(name = "ChuyenMon")
    private String chuyenMon;

    @Column(name = "KinhNghiem")
    private String kinhNghiem;

    public GiangVien() {
    }

    public GiangVien(String maGV, String tenGV, String chuyenMon, String kinhNghiem) {
        this.maGV = maGV;
        this.tenGV = tenGV;
        this.chuyenMon = chuyenMon;
        this.kinhNghiem = kinhNghiem;
    }

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

    public String getChuyenMon() {
        return chuyenMon;
    }

    public void setChuyenMon(String chuyenMon) {
        this.chuyenMon = chuyenMon;
    }

    public String getKinhNghiem() {
        return kinhNghiem;
    }

    public void setKinhNghiem(String kinhNghiem) {
        this.kinhNghiem = kinhNghiem;
    }
}


