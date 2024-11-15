package com.ltq27.Baotrimaylanh.repository;

import com.ltq27.Baotrimaylanh.entity.PhanCong;
import com.ltq27.Baotrimaylanh.mapper.TrangThaiPhanCong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PhanCongRepository extends JpaRepository<PhanCong, Long> {
    List<PhanCong> findByNhanVienId(Long nhanVienId);
    // Phương thức tìm kiếm phân công theo trạng thái
    List<PhanCong> findByTrangThai(TrangThaiPhanCong trangThai);
    Optional<PhanCong> findByThongTinDatLichIdAndNhanVienId(Long datLichId, Long nhanVienId);
}