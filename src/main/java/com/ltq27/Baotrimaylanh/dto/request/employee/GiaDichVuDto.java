package com.ltq27.Baotrimaylanh.dto.request.employee;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GiaDichVuDto {
    @NotNull(message = "Mã loại dịch vụ không được để trống")
    Long idDv;
    @NotNull(message = "Mã loại máy lạnh không được để trống")
    Long idLml;
    @NotNull(message = "Giá không được để trống")
    @Positive(message = "Giá phải là số dương")
    String price;

}
