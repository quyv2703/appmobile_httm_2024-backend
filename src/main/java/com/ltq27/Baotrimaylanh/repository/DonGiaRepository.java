package com.ltq27.Baotrimaylanh.repository;

import com.ltq27.Baotrimaylanh.entity.DonGia;
import com.ltq27.Baotrimaylanh.entity.GoiDichVu;
import com.ltq27.Baotrimaylanh.entity.LoaiMayLanh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DonGiaRepository extends JpaRepository<DonGia,Long> {
    List<DonGia> findAll();
    List<DonGia> findByGoiDichVu(GoiDichVu goiDichVu);
    @Query("SELECT d.id FROM DonGia d WHERE d.goiDichVu.id = :goiDichVuId AND d.loaiMayLanh.id = :loaiMayLanhId")
    Optional<Long> findIdByGoiDichVuIdAndLoaiMayLanhId(@Param("goiDichVuId") Long goiDichVuId, @Param("loaiMayLanhId") Long loaiMayLanhId);
    List<LoaiMayLanh> findDistinctByGoiDichVu_Id(Long goiDichVuId);
    List<DonGia> findByGoiDichVuId(Long goiDichVuId);
}
