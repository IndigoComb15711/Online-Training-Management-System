package com.example.quanlydaotao.controller;

import com.example.quanlydaotao.dto.*;
import com.example.quanlydaotao.entity.KhoaHoc;
import com.example.quanlydaotao.service.KhoaHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/khoahoc")
public class KhoaHocController {
    @Autowired
    private KhoaHocService khoaHocService;

    @PostMapping
    public KhoaHoc createKhoaHoc(@RequestBody KhoaHoc khoaHoc) {
        return khoaHocService.createKhoaHoc(khoaHoc);
    }

    @GetMapping
    public List<KhoaHoc> getAllKhoaHoc() {
        return khoaHocService.getAllKhoaHoc();
    }

    @GetMapping("/{id}")
    public ResponseEntity<KhoaHoc> getKhoaHocById(@PathVariable String id) {
        Optional<KhoaHoc> khoaHoc = khoaHocService.getKhoaHocById(id);
        return khoaHoc.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<KhoaHoc> updateKhoaHoc(@PathVariable String id, @RequestBody KhoaHoc khoaHoc) {
        if (!khoaHocService.getKhoaHocById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        khoaHoc.setMaKH(id);
        KhoaHoc updatedKhoaHoc = khoaHocService.updateKhoaHoc(khoaHoc);
        return ResponseEntity.ok(updatedKhoaHoc);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteKhoaHoc(@PathVariable String id) {
        if (!khoaHocService.getKhoaHocById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        khoaHocService.deleteKhoaHoc(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/danhsach-hocvien-dangky")
    public List<DanhSachTatCaHocVien> getDanhSachTatCaHocVien() {
        return khoaHocService.getDanhSachTatCaHocVien();
    }

    @GetMapping("/danhsach-hocvien-dangky-theo/{maKH}")
    public List<DanhSachHocVienTheoKhoaHoc> getDanhSachHocVienTheoKhoaHoc(@PathVariable String maKH) {
        return khoaHocService.getDanhSachHocVienTheoKhoaHoc(maKH);
    }

    @GetMapping("/timkiem-theo-giangvien/{maGV}")
    public List<TimKiemKhoaHocTheoGiangVien> getKhoaHocTheoGiangVien(@PathVariable String maGV) {
        return khoaHocService.getKhoaHocTheoGiangVien(maGV);
    }

    @GetMapping("/timkiem-theo-hocphi/{hocPhiMin}/{hocPhiMax}")
    public List<TimKiemKhoaHocTheoHocPhi> getKhoaHocTheoHocPhi(
            @PathVariable String hocPhiMin,
            @PathVariable String hocPhiMax) {
        return khoaHocService.getKhoaHocTheoHocPhi(hocPhiMin, hocPhiMax);
    }

    @GetMapping("/danhsach-hvhtkh")
    public List<DanhSachHVHTKH> getDanhSachHVHTKH() {
        return khoaHocService.getDanhSachHVHTKH();
    }

    @GetMapping("/danhsach-hvhtkh-theo/{maKH}")
    public List<TimKiemHVHTKHTheoMaKH> getTimKiemHVHTKHTheoMaKH(@PathVariable String maKH) {
        return khoaHocService.getTimKiemHVHTKHTheoMaKH(maKH);
    }

    @GetMapping("/khoa-hoc-pho-bien")
    public List<KhoaHocPhoBien> getKhoaHocPhoBien() {
        return khoaHocService.getKhoaHocPhoBien();
    }
}
