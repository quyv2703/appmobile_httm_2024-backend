package com.ltq27.Baotrimaylanh.dto.request.employee;

import com.ltq27.Baotrimaylanh.entity.Customer;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ThongTinDatLichDTO {
     Long id;
     Long customerId;
     Long donGiaId;
     LocalDate ngayThucHien;
     String diaChiThucHien;


}
