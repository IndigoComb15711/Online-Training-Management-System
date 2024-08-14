package com.example.quanlydaotao.service;

import com.example.quanlydaotao.dto.DanhSachHocVienTheoKhoaHoc;
import com.example.quanlydaotao.dto.DanhSachTatCaHocVien;
import com.example.quanlydaotao.dto.TongSoHocVienDangKyTheoNam;
import com.example.quanlydaotao.dto.TongSoHocVienDangKyTheoThangNam;
import com.example.quanlydaotao.entity.HocVien;
import com.example.quanlydaotao.repository.HocVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HocVienService {
    @Autowired
    private HocVienRepository hocVienRepository;

    public HocVien createHocVien(HocVien hocVien) {
        return hocVienRepository.save(hocVien);
    }

    public List<HocVien> getAllHocVien() {
        return hocVienRepository.findAll();
    }

    public Optional<HocVien> getHocVienById(String id) {
        return hocVienRepository.findById(id);
    }

    public HocVien updateHocVien(HocVien hocVien) {
        return hocVienRepository.save(hocVien);
    }

    public void deleteHocVien(String id) {
        hocVienRepository.deleteById(id);
    }

    public List<TongSoHocVienDangKyTheoNam> getTongSoHocVienDangKyTheoNam(int nam) {
        List<Object[]> results = hocVienRepository.getTongSoHocVienDangKyTheoNam(nam);
        List<TongSoHocVienDangKyTheoNam> danhSach = new ArrayList<>();

        for (Object[] result : results) {
            TongSoHocVienDangKyTheoNam dto = new TongSoHocVienDangKyTheoNam();
            dto.setThang((Integer) result[0]);
            dto.setSoHocVienDangKyThang(((Number) result[1]).longValue());
            dto.setTongSoHocVienDangKyTichLuy(((Number) result[2]).longValue());
            danhSach.add(dto);
        }

        return danhSach;
    }

    public List<TongSoHocVienDangKyTheoThangNam> getTongSoHocVienDangKyTheoThangNam(int thang, int nam) {
        List<Object[]> results = hocVienRepository.getTongSoHocVienDangKyTheoThangNam(thang, nam);
        List<TongSoHocVienDangKyTheoThangNam> danhSach = new ArrayList<>();

        for (Object[] result : results) {
            TongSoHocVienDangKyTheoThangNam dto = new TongSoHocVienDangKyTheoThangNam();
            dto.setNgay((Integer) result[0]);
            dto.setSoHocVienDangKyNgay((Integer) result[1]);
            dto.setTongSoHocVienDangKyTichLuy((Integer) result[2]);
            danhSach.add(dto);
        }

        return danhSach;
    }
}
