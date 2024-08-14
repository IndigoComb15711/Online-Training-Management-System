package com.example.quanlydaotao.repository;

import com.example.quanlydaotao.entity.HocVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HocVienRepository extends JpaRepository<HocVien, String> {

    @Query(value = "EXEC TongSoHocVienDangKyTheoNam :nam", nativeQuery = true)
    List<Object[]> getTongSoHocVienDangKyTheoNam(int nam);

    @Query(value = "EXEC TongSoHocVienDangKyTheoThangNam :thang, :nam", nativeQuery = true)
    List<Object[]> getTongSoHocVienDangKyTheoThangNam(int thang, int nam);
}
