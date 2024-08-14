package com.example.quanlydaotao.controller;

import com.example.quanlydaotao.dto.DanhSachHocVienTheoKhoaHoc;
import com.example.quanlydaotao.dto.DanhSachTatCaHocVien;
import com.example.quanlydaotao.dto.TongSoHocVienDangKyTheoNam;
import com.example.quanlydaotao.dto.TongSoHocVienDangKyTheoThangNam;
import com.example.quanlydaotao.entity.HocVien;
import com.example.quanlydaotao.service.HocVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hocvien")
public class HocVienController {
    @Autowired
    private HocVienService hocVienService;

    @PostMapping
    public HocVien createHocVien(@RequestBody HocVien hocVien) {
        return hocVienService.createHocVien(hocVien);
    }

    @GetMapping
    public List<HocVien> getAllHocVien() {
        return hocVienService.getAllHocVien();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HocVien> getHocVienById(@PathVariable String id) {
        Optional<HocVien> hocVien = hocVienService.getHocVienById(id);
        return hocVien.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<HocVien> updateHocVien(@PathVariable String id, @RequestBody HocVien hocVien) {
        if (!hocVienService.getHocVienById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        hocVien.setMaHV(id);
        HocVien updatedHocVien = hocVienService.updateHocVien(hocVien);
        return ResponseEntity.ok(updatedHocVien);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHocVien(@PathVariable String id) {
        if (!hocVienService.getHocVienById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        hocVienService.deleteHocVien(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/tong-so-hoc-vien-dang-ky-theo-nam/{nam}")
    public List<TongSoHocVienDangKyTheoNam> getTongSoHocVienDangKyTheoNam(@PathVariable int nam) {
        return hocVienService.getTongSoHocVienDangKyTheoNam(nam);
    }

    @GetMapping("/tong-so-hoc-vien-dang-ky-theo-thang-nam/{thang}/{nam}")
    public List<TongSoHocVienDangKyTheoThangNam> getTongSoHocVienDangKyTheoThangNam(
            @PathVariable int thang,
            @PathVariable int nam) {
        return hocVienService.getTongSoHocVienDangKyTheoThangNam(thang, nam);
    }
}
