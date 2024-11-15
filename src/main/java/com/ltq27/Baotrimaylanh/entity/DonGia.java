package com.ltq27.Baotrimaylanh.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "don_gia",
uniqueConstraints = @UniqueConstraint(columnNames = {"ma_goi_dich_vu", "ma_loai_may_lanh"}))
public class DonGia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ma_goi_dich_vu")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    GoiDichVu goiDichVu;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ma_loai_may_lanh")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    LoaiMayLanh loaiMayLanh;
    Double price;

}
