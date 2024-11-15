package com.ltq27.Baotrimaylanh.dto.request.employee;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DichVuCreationRequest {
  //  @Size(min =10,message = "ten phai toi thieu 10 ki tu")
     String name;

}
