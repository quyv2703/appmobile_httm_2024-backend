package com.ltq27.Baotrimaylanh.repository;

import com.ltq27.Baotrimaylanh.entity.DichVu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DichVuRepository extends JpaRepository<DichVu,Long> {

}
