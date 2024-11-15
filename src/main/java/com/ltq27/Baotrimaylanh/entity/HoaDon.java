package com.ltq27.Baotrimaylanh.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;


@Entity
@Table(name = "lich_su_hoa_don")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @OneToOne
    @JoinColumn(name = "thong_tin_dat_lich_id", referencedColumnName = "id")
    @JsonBackReference
    ThongTinDatLich thongTinDatLich;

    LocalDate ngayThanhToan;
    int trangThaiThanhToan;

    Double tongTien;
}