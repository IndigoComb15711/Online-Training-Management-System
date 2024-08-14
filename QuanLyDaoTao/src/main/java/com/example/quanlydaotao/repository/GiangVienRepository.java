package com.example.quanlydaotao.repository;

import com.example.quanlydaotao.entity.GiangVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GiangVienRepository extends JpaRepository<GiangVien, String> {

    @Query(value = "EXEC sp_ThongKeHocVienTheoGiangVien :MaGV", nativeQuery = true)
    List<Object[]> getThongKeHocVienTheoGiangVien(@Param("MaGV") String maGV);

    @Query(value = "EXEC sp_DanhSachGiangVienNhieuHocVienNhat", nativeQuery = true)
    List<Object[]> getDanhSachGiangVienNhieuHocVienNhat();

    @Query(value = "EXEC sp_XemLichGiangDay", nativeQuery = true)
    List<Object[]> getXemLichGiangDay();
}