package com.ltq27.Baotrimaylanh.controller;

import com.ltq27.Baotrimaylanh.dto.request.customer.NhanXetDTO;
import com.ltq27.Baotrimaylanh.dto.response.NhanXetResponseDTO;
import com.ltq27.Baotrimaylanh.entity.NhanXet;
import com.ltq27.Baotrimaylanh.service.NhanXetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/nhanxet")
public class NhanXetController {

    @Autowired
    private NhanXetService nhanXetService;

    @PostMapping("/them")
    public ResponseEntity<NhanXetResponseDTO> addNhanXet(@RequestBody NhanXetDTO nhanXetDTO) {
        NhanXetResponseDTO responseDTO = nhanXetService.addNhanXet(nhanXetDTO);
        return ResponseEntity.ok(responseDTO);
    }
    // API lấy bình luận theo một nhãn
    @GetMapping("/filter")
    public ResponseEntity<List<NhanXetResponseDTO>> getNhanXetByLabel(
            @RequestParam(required = false) String label) {

        if (label != null) {
            return ResponseEntity.ok(nhanXetService.getNhanXetByLabel(label));
        } else {
            return ResponseEntity.badRequest().body(Collections.emptyList());
        }
    }
    @GetMapping("/goiDichVu/{goiDichVuId}")
    public ResponseEntity<List<NhanXetResponseDTO>> getNhanXetByGoiDichVu(@PathVariable Long goiDichVuId) {
        List<NhanXetResponseDTO> nhanXets = nhanXetService.getNhanXetByGoiDichVu(goiDichVuId);
        return ResponseEntity.ok(nhanXets);
    }
}