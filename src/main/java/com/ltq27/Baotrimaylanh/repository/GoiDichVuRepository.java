package com.ltq27.Baotrimaylanh.repository;

import com.ltq27.Baotrimaylanh.entity.GoiDichVu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoiDichVuRepository extends JpaRepository<GoiDichVu,Long> {
}
