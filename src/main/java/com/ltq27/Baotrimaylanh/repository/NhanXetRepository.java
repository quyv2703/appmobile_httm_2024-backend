package com.ltq27.Baotrimaylanh.repository;

import com.ltq27.Baotrimaylanh.entity.NhanXet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NhanXetRepository extends JpaRepository<NhanXet, Long> {
    List<NhanXet> findByGoiDichVuId(Long goiDichVuId);
    List<NhanXet> findByLabel(String label);
}
