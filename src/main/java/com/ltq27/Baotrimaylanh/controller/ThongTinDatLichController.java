package com.ltq27.Baotrimaylanh.controller;

import com.ltq27.Baotrimaylanh.dto.request.employee.DanhSachDatLichDto;
import com.ltq27.Baotrimaylanh.dto.request.employee.ThongTinDatLichDTO;
import com.ltq27.Baotrimaylanh.dto.request.employee.TrangThaiDuyetDTO;
import com.ltq27.Baotrimaylanh.dto.request.employee.dto.DatLichStatusDTO;
import com.ltq27.Baotrimaylanh.entity.ThongTinDatLich;
import com.ltq27.Baotrimaylanh.service.ThongTinDatLichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/thongtindatlich")
public class ThongTinDatLichController {

    @Autowired
    private ThongTinDatLichService thongTinDatLichService;

    @GetMapping("/status")
    public ResponseEntity<List<DatLichStatusDTO>> getDatLichStatus(@RequestParam Long customerId) {
        List<DatLichStatusDTO> statusList = thongTinDatLichService.getDatLichStatus(customerId);
        return ResponseEntity.ok(statusList);
    }
    @PostMapping
    public ResponseEntity<ThongTinDatLich> addThongTinDatLich(@RequestBody ThongTinDatLichDTO  thongTinDatLich) {
        ThongTinDatLich savedThongTinDatLich = thongTinDatLichService.datLich(thongTinDatLich);
        return ResponseEntity.ok(savedThongTinDatLich);
    }
    @GetMapping
    public ResponseEntity<List<DanhSachDatLichDto>> getAllThongTinDatLich() {
        List<DanhSachDatLichDto> responseList = thongTinDatLichService.getAllThongTinDatLich();
        return ResponseEntity.ok(responseList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ThongTinDatLich> getThongTinDatLich(@PathVariable Long id) {
        Optional<ThongTinDatLich> thongTinDatLich = thongTinDatLichService.getThongTinDatLich(id);
        return thongTinDatLich.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void deleteThongTinDatLich(@PathVariable Long id) {
        thongTinDatLichService.deleteThongTinDatLich(id);
    }

    @PatchMapping("/{id}/trang-thai")
    public ResponseEntity<?> updateTrangThaiDuyet(@PathVariable Long id, @RequestBody TrangThaiDuyetDTO dto) {
        return thongTinDatLichService.updateTrangThaiDuyet(id, dto.getTrangThaiDuyet())
                .map(updatedThongTinDatLich -> ResponseEntity.ok(updatedThongTinDatLich))
                .orElse(ResponseEntity.notFound().build());
    }
    @PatchMapping("/manager/{idDatLich}/{idManager}")
    public Optional<ThongTinDatLich> updateManagerId(@PathVariable Long idDatLich, @PathVariable Long idManager){
        return thongTinDatLichService.updateIdManager(idDatLich,idManager);
    }
}