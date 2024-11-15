package com.ltq27.Baotrimaylanh.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NhanXetResponseDTO {
    private String customerName;
    private String servicePackageName;
    private int start;
    private String comment;
    private String label;

    public NhanXetResponseDTO(String customerName, String servicePackageName, int star, String comment, String label) {
        this.customerName = customerName;
        this.servicePackageName = servicePackageName;
        this.start = star;
        this.comment = comment;
        this.label = label;
    }
}
