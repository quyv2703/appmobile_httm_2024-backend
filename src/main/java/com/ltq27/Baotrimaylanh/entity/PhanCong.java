package com.ltq27.Baotrimaylanh.entity;

import com.ltq27.Baotrimaylanh.mapper.TrangThaiPhanCong;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "phan_cong", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"ma_dat_lich", "ma_nhan_vien"})
})
public class PhanCong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Long id;

    @ManyToOne
    @JoinColumn(name = "ma_dat_lich", nullable = false)
     ThongTinDatLich thongTinDatLich;

    @ManyToOne
    @JoinColumn(name = "ma_nhan_vien", nullable = false)
     Employee nhanVien;

    @Enumerated(EnumType.STRING)
    TrangThaiPhanCong trangThai;


}
