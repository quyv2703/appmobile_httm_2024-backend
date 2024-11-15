package com.ltq27.Baotrimaylanh.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "gia_dich_vu",uniqueConstraints = {
        @UniqueConstraint(columnNames = {"id","id"})
})
public class GiaDichVu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    @JoinColumn(name = "dich_vu_id",nullable = false)
    DichVu dichVu;
    @ManyToOne
    @JoinColumn(name = "loai_may_lanh_id",nullable = false)
    LoaiMayLanh loaiMayLanh;
    String price;

}
