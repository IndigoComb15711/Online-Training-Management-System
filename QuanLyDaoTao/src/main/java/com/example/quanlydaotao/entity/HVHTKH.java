package com.example.quanlydaotao.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "HVHTKH")
@Data
public class HVHTKH {
    @Id
    @Column(name = "MaHV")
    private String maHV;

    @Column(name = "MaKH")
    private String maKH;

    public HVHTKH() {
    }

    public HVHTKH(String maHV, String maKH) {
        this.maHV = maHV;
        this.maKH = maKH;
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
}


