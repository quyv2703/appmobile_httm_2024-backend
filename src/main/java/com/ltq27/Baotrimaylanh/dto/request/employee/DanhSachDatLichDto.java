package com.ltq27.Baotrimaylanh.dto.request.employee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DanhSachDatLichDto {
    private Long id;
    private String tenKhachHang;
    private String goiDichVu;
    private String ngayThucHien;
    private String diaChiThucHien;
    private String trangThaiDuyet;


}
