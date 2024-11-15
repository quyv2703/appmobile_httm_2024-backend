package com.ltq27.Baotrimaylanh.repository;

import com.ltq27.Baotrimaylanh.entity.DichVu;
import com.ltq27.Baotrimaylanh.entity.GiaDichVu;
import com.ltq27.Baotrimaylanh.entity.LoaiMayLanh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GiaDichVuRepository extends JpaRepository<GiaDichVu,Long> {
    boolean existsByDichVuAndLoaiMayLanh(DichVu dichVu, LoaiMayLanh loaiMayLanh);
    List<GiaDichVu> findByDichVu(DichVu dichVu);
    GiaDichVu findByDichVuAndLoaiMayLanh(DichVu dichVu, LoaiMayLanh loaiMayLanh);
}
