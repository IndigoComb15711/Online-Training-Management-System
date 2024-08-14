package com.example.quanlydaotao.repository;

import com.example.quanlydaotao.entity.KhoaHoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KhoaHocRepository extends JpaRepository<KhoaHoc, String> {
    @Query(value = "EXEC sp_DanhSachTatCaHocVien", nativeQuery = true)
    List<Object[]> getDanhSachTatCaHocVien();

    @Query(value = "EXEC sp_DanhSachHocVienTheoKhoaHoc :MaKH", nativeQuery = true)
    List<Object[]> getDanhSachHocVienTheoKhoaHoc(@Param("MaKH") String maKH);

    @Query(value = "EXEC TimKiemKhoaHocTheoGiangVien :MaGV", nativeQuery = true)
    List<Object[]> getKhoaHocTheoGiangVien(@Param("MaGV") String maGV);

    @Query(value = "EXEC TimKiemKhoaHocTheoHocPhi :HocPhiMin, :HocPhiMax", nativeQuery = true)
    List<Object[]> getKhoaHocTheoHocPhi(@Param("HocPhiMin") String hocPhiMin, @Param("HocPhiMax") String hocPhiMax);

    @Query(value = "EXEC sp_DanhSachHVHTKH", nativeQuery = true)
    List<Object[]> getDanhSachHVHTKH();

    @Query(value = "EXEC sp_TimKiemHVHTKHTheoMaKH :MaKhoaHoc", nativeQuery = true)
    List<Object[]> getTimKiemHVHTKHTheoMaKH(@Param("MaKhoaHoc") String maKhoaHoc);

    @Query(value = "EXEC sp_KhoaHocPhoBien", nativeQuery = true)
    List<Object[]> getKhoaHocPhoBien();
}