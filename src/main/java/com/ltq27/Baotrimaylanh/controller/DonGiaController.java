package com.ltq27.Baotrimaylanh.controller;

import com.ltq27.Baotrimaylanh.dto.request.employee.DonGiaDTO;
import com.ltq27.Baotrimaylanh.entity.DonGia;
import com.ltq27.Baotrimaylanh.entity.LoaiMayLanh;
import com.ltq27.Baotrimaylanh.service.DonGiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/dongia")
public class DonGiaController {
    @Autowired
    private DonGiaService donGiaService;

    @GetMapping("/all")
    public List<DonGia> getAllDonGia() {
        return donGiaService.getAllDonGia();
    }
    @GetMapping("/search")
    public ResponseEntity<Long> getDonGiaId(@RequestParam Long goiDichVuId, @RequestParam Long loaiMayLanhId) {
        Optional<Long> donGiaId = donGiaService.getDonGiaByGoiDichVuIdAndLoaiMayLanhId(goiDichVuId, loaiMayLanhId);
        return donGiaId.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/listloaimaylanh/{id}")
    public ResponseEntity<List<LoaiMayLanh>> getLoaiMayLanhByGoiDichVuId(@PathVariable Long id) {
        List<LoaiMayLanh> loaiMayLanhList = donGiaService.getLoaiMayLanhByGoiDichVuId(id);
        return ResponseEntity.ok(loaiMayLanhList);
    }

    @GetMapping("/{id}")
    public Optional<DonGia> getDonGiaById(@PathVariable Long id) {
        return donGiaService.getDonGiaById(id);
    }

    @PostMapping
    public DonGia createDonGia(@RequestBody DonGiaDTO donGia) {
        return donGiaService.saveDonGia(donGia);
    }

    @DeleteMapping("/{id}")
    public void deleteDonGia(@PathVariable Long id) {
        donGiaService.deleteDonGia(id);
    }

    @PutMapping("/{id}")
    public Optional<DonGia> updateDonGia(@PathVariable Long id, @RequestBody DonGia updatedDonGia) {
        return donGiaService.updateDonGia(id, updatedDonGia);
    }
}
