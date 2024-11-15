package com.ltq27.Baotrimaylanh.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class NhanXet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    @JoinColumn(name = "ma_goi_dich_vu")
    GoiDichVu goiDichVu;

    @ManyToOne
    @JoinColumn(name="ma_khach_hang")
    Customer customer;

    int start;
    String comment;
    String label;
}
