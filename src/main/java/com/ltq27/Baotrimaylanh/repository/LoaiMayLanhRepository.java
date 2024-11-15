package com.ltq27.Baotrimaylanh.repository;

import com.ltq27.Baotrimaylanh.entity.LoaiMayLanh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoaiMayLanhRepository extends JpaRepository<LoaiMayLanh, Long> {
    LoaiMayLanh findByName(String name);
}
