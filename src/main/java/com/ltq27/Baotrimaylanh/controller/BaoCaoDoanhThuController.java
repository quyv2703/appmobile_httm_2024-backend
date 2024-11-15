package com.ltq27.Baotrimaylanh.controller;

import com.ltq27.Baotrimaylanh.dto.request.employee.BaoCaoDoanhThuAll;
import com.ltq27.Baotrimaylanh.service.BaoCaoDoanhThuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bao-cao-doanh-thu")
public class BaoCaoDoanhThuController {

    @Autowired
    private BaoCaoDoanhThuService baoCaoDoanhThuService;

    @GetMapping("/report")
    public ResponseEntity<BaoCaoDoanhThuAll> layBaoCaoDoanhThu() {
        BaoCaoDoanhThuAll baoCao = baoCaoDoanhThuService.taoBaoCaoDoanhThu();
        return ResponseEntity.ok(baoCao);
    }
}