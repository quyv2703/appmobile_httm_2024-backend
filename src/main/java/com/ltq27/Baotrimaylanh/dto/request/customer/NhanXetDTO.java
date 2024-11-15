package com.ltq27.Baotrimaylanh.dto.request.customer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NhanXetDTO {
    private Long goiDichVuId;
    private Long customerId;
    private int start;
    private String comment;
    private String label;
}