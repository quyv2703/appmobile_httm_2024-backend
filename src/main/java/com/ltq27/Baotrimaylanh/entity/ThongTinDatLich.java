package com.ltq27.Baotrimaylanh.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Entity
@Table(name = "thong_tin_dat_lich", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"dia_chi_thuc_hien", "ma_don_gia", "id_khach"})
})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ThongTinDatLich {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name= "id_khach")
    Customer customer;
    // đây là mã giá
    @ManyToOne
    @JoinColumn(name = "ma_don_gia")
    DonGia donGia;
    // hôm nay đặt
    LocalDate ngayDat;
    LocalDate ngayThucHien;
    String diaChiThucHien;
    int trangThaiDuyet;
    @ManyToOne
    @JoinColumn(name = "ma_quan_ly")
    Employee managerId;

    @OneToOne(mappedBy = "thongTinDatLich", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    HoaDon lichSuHoaDon;
}
