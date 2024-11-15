package com.ltq27.Baotrimaylanh.repository;

import com.ltq27.Baotrimaylanh.entity.ThongTinDatLich;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ThongTinDatLichRepository extends JpaRepository<ThongTinDatLich, Long> {
    List<ThongTinDatLich> findByCustomerId(Long customerId);
}