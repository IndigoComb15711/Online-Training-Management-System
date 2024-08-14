package com.example.quanlydaotao.controller;

import com.example.quanlydaotao.dto.DanhSachGiangVienNhieuHocVienNhat;
import com.example.quanlydaotao.dto.ThongKeHocVienTheoGiangVien;
import com.example.quanlydaotao.dto.XemLichGiangDay;
import com.example.quanlydaotao.entity.GiangVien;
import com.example.quanlydaotao.service.GiangVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/giangvien")
public class GiangVienController {
    @Autowired
    private GiangVienService giangVienService;

    @PostMapping
    public GiangVien createGiangVien(@RequestBody GiangVien giangVien) {
        return giangVienService.createGiangVien(giangVien);
    }

    @GetMapping
    public List<GiangVien> getAllGiangVien() {
        return giangVienService.getAllGiangVien();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GiangVien> getGiangVienById(@PathVariable String id) {
        Optional<GiangVien> giangVien = giangVienService.getGiangVienById(id);
        return giangVien.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<GiangVien> updateGiangVien(@PathVariable String id, @RequestBody GiangVien giangVien) {
        if (!giangVienService.getGiangVienById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        giangVien.setMaGV(id);
        GiangVien updatedGiangVien = giangVienService.updateGiangVien(giangVien);
        return ResponseEntity.ok(updatedGiangVien);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGiangVien(@PathVariable String id) {
        if (!giangVienService.getGiangVienById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        giangVienService.deleteGiangVien(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/thongke-hocvien/{maGV}")
    public List<ThongKeHocVienTheoGiangVien> getThongKeHocVienTheoGiangVien(@PathVariable String maGV) {
        return giangVienService.getThongKeHocVienTheoGiangVien(maGV);
    }

    @GetMapping("/giang-vien-nhieu-hoc-vien-nhat")
    public List<DanhSachGiangVienNhieuHocVienNhat> getDanhSachGiangVienNhieuHocVienNhat() {
        return giangVienService.getDanhSachGiangVienNhieuHocVienNhat();
    }

    @GetMapping("/lich-giang-day")
    public List<XemLichGiangDay> getXemLichGiangDay() {
        return giangVienService.getXemLichGiangDay();
    }
}

