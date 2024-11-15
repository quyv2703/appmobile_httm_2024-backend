package com.ltq27.Baotrimaylanh.dto;

import com.ltq27.Baotrimaylanh.entity.DichVu;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class ServiceWithPriceRange {
     DichVu dichVu;
     String minPrice;
     String maxPrice;
}
