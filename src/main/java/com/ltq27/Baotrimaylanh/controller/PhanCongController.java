package com.ltq27.Baotrimaylanh.controller;

import com.ltq27.Baotrimaylanh.dto.request.employee.PhanCongRequest;
import com.ltq27.Baotrimaylanh.dto.request.employee.TrangThaiPhanCongRequest;
import com.ltq27.Baotrimaylanh.entity.PhanCong;
import com.ltq27.Baotrimaylanh.service.PhanCongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ltq27.Baotrimaylanh.mapper.TrangThaiPhanCong;

import java.util.List;

@RestController
@RequestMapping("/api/phancong")
public class PhanCongController {
    @Autowired
    private PhanCongService phanCongService;
    @GetMapping("/trangthaituchoi")
    public List<PhanCong> getPhanCongByTrangThai(@RequestParam("trangThai") TrangThaiPhanCong trangThai) {
        return phanCongService.getPhanCongByTrangThai(trangThai);
    }
    // cập nhật id nhân viên mới khi bị từ chối
    @PutMapping("/{id}/nhan-vien")
    public ResponseEntity<PhanCong> updateNhanVien(@PathVariable Long id, @RequestParam Long maNhanVienMoi) {
        PhanCong updatedPhanCong = phanCongService.updateNhanVienVaTrangThai(id, maNhanVienMoi);
        return ResponseEntity.ok(updatedPhanCong);
    }
    @PostMapping
    public ResponseEntity<PhanCong> taoPhanCong(@RequestBody PhanCongRequest request) {
        PhanCong phanCong = phanCongService.taoPhanCong(request.getMaDatLich(), request.getMaNhanVien());
        return ResponseEntity.status(HttpStatus.CREATED).body(phanCong);
    }

    @PatchMapping("/{id}/trang-thai")
    public ResponseEntity<PhanCong> capNhatTrangThaiPhanCong(
            @PathVariable Long id,
            @RequestBody TrangThaiPhanCongRequest request) {
        PhanCong phanCong = phanCongService.capNhatTrangThaiPhanCong(id, request.getTrangThai());
        return ResponseEntity.ok(phanCong);
    }

    @GetMapping("/nhanvien/{maNhanVien}")
    public ResponseEntity<List<PhanCong>> layDanhSachPhanCongTheoNhanVien(@PathVariable Long maNhanVien) {
        List<PhanCong> danhSachPhanCong = phanCongService.layDanhSachPhanCongTheoNhanVien(maNhanVien);
        return ResponseEntity.ok(danhSachPhanCong);
    }
}