package com.ltq27.Baotrimaylanh.dto.request.employee.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DatLichStatusDTO {
    private Long id;
    private LocalDate ngayDat;
    private LocalDate ngayThucHien;
    private String diaChiThucHien;
    private int trangThaiDuyet;
    private String tenGoiDichVu;
    private String tenLoaiMayLanh;
}
