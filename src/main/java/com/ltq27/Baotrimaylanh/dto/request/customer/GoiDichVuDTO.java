package com.ltq27.Baotrimaylanh.dto.request.customer;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GoiDichVuDTO {
     Long goiDichVuId;
     String tenGoi;
     String description;
     List<LoaiMayLanhGiaDTO> loaiMayLanhGiaList;
}
