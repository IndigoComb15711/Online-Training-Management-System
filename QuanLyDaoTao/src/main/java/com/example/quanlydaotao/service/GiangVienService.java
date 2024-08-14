package com.example.quanlydaotao.service;

import com.example.quanlydaotao.dto.DanhSachGiangVienNhieuHocVienNhat;
import com.example.quanlydaotao.dto.ThongKeHocVienTheoGiangVien;
import com.example.quanlydaotao.dto.XemLichGiangDay;
import com.example.quanlydaotao.entity.GiangVien;
import com.example.quanlydaotao.repository.GiangVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GiangVienService {
    @Autowired
    private GiangVienRepository giangVienRepository;

    public GiangVien createGiangVien(GiangVien giangVien) {
        return giangVienRepository.save(giangVien);
    }

    public List<GiangVien> getAllGiangVien() {
        return giangVienRepository.findAll();
    }

    public Optional<GiangVien> getGiangVienById(String id) {
        return giangVienRepository.findById(id);
    }

    public GiangVien updateGiangVien(GiangVien hocVien) {
        return giangVienRepository.save(hocVien);
    }

    public void deleteGiangVien(String id) {
        giangVienRepository.deleteById(id);
    }

    public List<ThongKeHocVienTheoGiangVien> getThongKeHocVienTheoGiangVien(String maGV) {
        List<Object[]> results = giangVienRepository.getThongKeHocVienTheoGiangVien(maGV);
        List<ThongKeHocVienTheoGiangVien> danhSach = new ArrayList<>();

        for (Object[] result : results) {
            ThongKeHocVienTheoGiangVien dto = new ThongKeHocVienTheoGiangVien();
            dto.setMaHV((String) result[0]);
            dto.setTenHV((String) result[1]);
            danhSach.add(dto);
        }

        return danhSach;
    }

    public List<DanhSachGiangVienNhieuHocVienNhat> getDanhSachGiangVienNhieuHocVienNhat() {
        List<Object[]> results = giangVienRepository.getDanhSachGiangVienNhieuHocVienNhat();
        List<DanhSachGiangVienNhieuHocVienNhat> danhSach = new ArrayList<>();

        for (Object[] result : results) {
            DanhSachGiangVienNhieuHocVienNhat dto = new DanhSachGiangVienNhieuHocVienNhat();
            dto.setMaGV((String) result[0]);
            dto.setTenGV((String) result[1]);
            dto.setTenKH((String) result[2]);
            dto.setSoLuongHocVien(((Number) result[3]).longValue());
            danhSach.add(dto);
        }

        return danhSach;
    }

    public List<XemLichGiangDay> getXemLichGiangDay() {
        List<Object[]> results = giangVienRepository.getXemLichGiangDay();
        List<XemLichGiangDay> danhSach = new ArrayList<>();

        for (Object[] result : results) {
            XemLichGiangDay dto = new XemLichGiangDay();
            dto.setMaLich((String) result[0]);
            dto.setMaGV((String) result[1]);
            dto.setTenGV((String) result[2]);
            dto.setMaKH((String) result[3]);
            dto.setTenKH((String) result[4]);
            dto.setNgayGiangDay((String) result[5]);
            dto.setKhungGio((String) result[6]);
            danhSach.add(dto);
        }

        return danhSach;
    }
}
