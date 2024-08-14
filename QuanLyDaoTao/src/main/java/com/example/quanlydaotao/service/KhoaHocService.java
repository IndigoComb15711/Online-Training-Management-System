package com.example.quanlydaotao.service;

import com.example.quanlydaotao.dto.*;
import com.example.quanlydaotao.entity.KhoaHoc;
import com.example.quanlydaotao.repository.KhoaHocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.math.BigDecimal;

@Service
public class KhoaHocService {
    @Autowired
    private KhoaHocRepository khoaHocRepository;

    public KhoaHoc createKhoaHoc(KhoaHoc khoaHoc) {
        return khoaHocRepository.save(khoaHoc);
    }

    public List<KhoaHoc> getAllKhoaHoc() {
        return khoaHocRepository.findAll();
    }

    public Optional<KhoaHoc> getKhoaHocById(String id) {
        return khoaHocRepository.findById(id);
    }

    public KhoaHoc updateKhoaHoc(KhoaHoc khoaHoc) {
        return khoaHocRepository.save(khoaHoc);
    }

    public void deleteKhoaHoc(String id) {
        khoaHocRepository.deleteById(id);
    }

    public List<DanhSachTatCaHocVien> getDanhSachTatCaHocVien() {
        List<Object[]> results = khoaHocRepository.getDanhSachTatCaHocVien();
        List<DanhSachTatCaHocVien> danhSach = new ArrayList<>();

        for (Object[] result : results) {
            DanhSachTatCaHocVien dto = new DanhSachTatCaHocVien();
            dto.setMaKH((String) result[0]);
            dto.setTenKH((String) result[1]);
            dto.setMaHV((String) result[2]);
            dto.setTenHV((String) result[3]);
            dto.setNgayDK((Date) result[4]);
            dto.setTinhTrangDK((String) result[5]);
            danhSach.add(dto);
        }

        return danhSach;
    }

    public List<DanhSachHocVienTheoKhoaHoc> getDanhSachHocVienTheoKhoaHoc(String maKH) {
        List<Object[]> results = khoaHocRepository.getDanhSachHocVienTheoKhoaHoc(maKH);
        List<DanhSachHocVienTheoKhoaHoc> danhSach = new ArrayList<>();

        for (Object[] result : results) {
            DanhSachHocVienTheoKhoaHoc dto = new DanhSachHocVienTheoKhoaHoc();
            dto.setMaKH((String) result[0]);
            dto.setTenKH((String) result[1]);
            dto.setMaHV((String) result[2]);
            dto.setTenHV((String) result[3]);
            dto.setNgayDK((Date) result[4]);
            dto.setTinhTrangDK((String) result[5]);
            danhSach.add(dto);
        }

        return danhSach;
    }

    public List<TimKiemKhoaHocTheoGiangVien> getKhoaHocTheoGiangVien(String maGV) {
        List<Object[]> results = khoaHocRepository.getKhoaHocTheoGiangVien(maGV);
        List<TimKiemKhoaHocTheoGiangVien> danhSach = new ArrayList<>();

        for (Object[] result : results) {
            TimKiemKhoaHocTheoGiangVien dto = new TimKiemKhoaHocTheoGiangVien();
            dto.setMaKH((String) result[0]);
            dto.setTenKH((String) result[1]);
            dto.setThoiLuong((String) result[2]);
            dto.setHocPhi((BigDecimal) result[3]);
            danhSach.add(dto);
        }

        return danhSach;
    }

    public List<TimKiemKhoaHocTheoHocPhi> getKhoaHocTheoHocPhi(String hocPhiMin, String hocPhiMax) {
        List<Object[]> results = khoaHocRepository.getKhoaHocTheoHocPhi(hocPhiMin, hocPhiMax);
        List<TimKiemKhoaHocTheoHocPhi> danhSach = new ArrayList<>();

        for (Object[] result : results) {
            TimKiemKhoaHocTheoHocPhi dto = new TimKiemKhoaHocTheoHocPhi();
            dto.setMaKH((String) result[0]);
            dto.setTenKH((String) result[1]);
            dto.setThoiLuong((String) result[2]);
            dto.setHocPhi((BigDecimal) result[3]);
            danhSach.add(dto);
        }

        return danhSach;
    }

    public List<DanhSachHVHTKH> getDanhSachHVHTKH() {
        List<Object[]> results = khoaHocRepository.getDanhSachHVHTKH();
        List<DanhSachHVHTKH> danhSach = new ArrayList<>();

        for (Object[] result : results) {
            DanhSachHVHTKH dto = new DanhSachHVHTKH();
            dto.setMaHV((String) result[0]);
            dto.setTenHV((String) result[1]);
            dto.setDiaChi((String) result[2]);
            dto.setSdt((String) result[3]);
            dto.setEmail((String) result[4]);
            danhSach.add(dto);
        }

        return danhSach;
    }

    public List<TimKiemHVHTKHTheoMaKH> getTimKiemHVHTKHTheoMaKH(String maKhoaHoc) {
        List<Object[]> results = khoaHocRepository.getTimKiemHVHTKHTheoMaKH(maKhoaHoc);
        List<TimKiemHVHTKHTheoMaKH> danhSach = new ArrayList<>();

        for (Object[] result : results) {
            TimKiemHVHTKHTheoMaKH dto = new TimKiemHVHTKHTheoMaKH();
            dto.setMaHV((String) result[0]);
            dto.setTenHV((String) result[1]);
            dto.setDiaChi((String) result[2]);
            dto.setSdt((String) result[3]);
            dto.setEmail((String) result[4]);
            danhSach.add(dto);
        }

        return danhSach;
    }

    public List<KhoaHocPhoBien> getKhoaHocPhoBien() {
        List<Object[]> results = khoaHocRepository.getKhoaHocPhoBien();
        List<KhoaHocPhoBien> danhSach = new ArrayList<>();

        for (Object[] result : results) {
            KhoaHocPhoBien dto = new KhoaHocPhoBien();
            dto.setMaKH((String) result[0]);
            dto.setTenKH((String) result[1]);
            dto.setTenGiangVien((String) result[2]);
            dto.setThoiLuong((String) result[3]);
            dto.setHocPhi((BigDecimal) result[4]); // Chuyển đổi về BigDecimal
            dto.setSoLuongHocVien(((Number) result[5]).longValue());
            danhSach.add(dto);
        }

        return danhSach;
    }
}
