package com.ltq27.Baotrimaylanh.dto.request.customer;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LoaiMayLanhGiaDTO {
    private Long loaiMayLanhId;
    private String tenLoaiMayLanh;
    private Double gia;

    // getters and setters
}