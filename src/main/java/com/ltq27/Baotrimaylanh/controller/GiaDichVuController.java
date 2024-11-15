package com.ltq27.Baotrimaylanh.controller;

import com.ltq27.Baotrimaylanh.dto.request.employee.GiaDichVuDto;
import com.ltq27.Baotrimaylanh.entity.GiaDichVu;
import com.ltq27.Baotrimaylanh.service.GiaDichVuService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/giadichvu")
public class GiaDichVuController {
    @Autowired
    private GiaDichVuService giaDichVuService;
    @PostMapping
    public ResponseEntity<?> createGiaDichVu(@Valid  @RequestBody GiaDichVuDto dto){
        GiaDichVu giaDichVu=giaDichVuService.createGiaDichVu(dto);
        return ResponseEntity.ok(giaDichVu);
    }
   /* @GetMapping("/{id}")
    public ResponseEntity<?> getGiaDichVu(@PathVariable Long id) {
        GiaDichVu giaDichVu = giaDichVuService.getGiaDichVu(id);
        return ResponseEntity.ok(giaDichVu);
    }
*/
    @GetMapping
    public ResponseEntity<?> getAllGiaDichVu() {
        List<GiaDichVu> giaDichVuList = giaDichVuService.getAllGiaDichVu();
        return ResponseEntity.ok(giaDichVuList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateGiaDichVu(@PathVariable Long id, @Valid @RequestBody GiaDichVuDto dto) {
        GiaDichVu giaDichVu = giaDichVuService.updateGiaDichVu(id, dto);
        return ResponseEntity.ok(giaDichVu);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteGiaDichVu(@PathVariable Long id) {
        giaDichVuService.deleteGiaDichVu(id);
        return ResponseEntity.ok().build();
    }
}
