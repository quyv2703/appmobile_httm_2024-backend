package com.ltq27.Baotrimaylanh.controller;

import com.ltq27.Baotrimaylanh.dto.request.ApiResponse;
import com.ltq27.Baotrimaylanh.dto.request.customer.GoiDichVuDTO;
import com.ltq27.Baotrimaylanh.entity.GoiDichVu;
import com.ltq27.Baotrimaylanh.service.GoiDichVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/goidichvu")
public class GoiDichVuController {
    @Autowired
    private GoiDichVuService goiDichVuService;
    @GetMapping("/customerview")
    public ResponseEntity<List<GoiDichVuDTO>> getGoiDichVuList() {
        List<GoiDichVuDTO> goiDichVuList = goiDichVuService.getAllGoiDichVuWithPrices();
        return ResponseEntity.ok(goiDichVuList);
    }

    @GetMapping
    public ApiResponse<List<GoiDichVu>> getAllGoiDichVu(){
        ApiResponse<List<GoiDichVu>> apiResponse= new ApiResponse<>();
        apiResponse.setResult(goiDichVuService.getAllGoiDichVu());
        apiResponse.setMessage("Danh sách gói dịch vụ");
        return apiResponse;
    }
    @PostMapping
    public ApiResponse<GoiDichVu> createGoiDichVu(@RequestBody GoiDichVu goiDichVu){
        ApiResponse<GoiDichVu> apiResponse= new ApiResponse<>();
        apiResponse.setResult(goiDichVuService.createGoiDichVu(goiDichVu));
        apiResponse.setMessage("Tạo gói dịch vụ thành công");
        return  apiResponse;
    }
    @DeleteMapping("/{id}")
    public ApiResponse<GoiDichVu> deleteGoiDichVu(@PathVariable Long id){
        ApiResponse<GoiDichVu> apiResponse= new ApiResponse<>();
        apiResponse.setMessage("Xóa thành công dịch vụ");
        apiResponse.setResult(goiDichVuService.deleteGoiDichVu(id));
        return apiResponse;
    }
    @PutMapping("/{id}")
    public ApiResponse<GoiDichVu> updateGoiDichVu(@PathVariable Long id,@RequestBody GoiDichVu request){
        ApiResponse<GoiDichVu> apiResponse= new ApiResponse<>();
        apiResponse.setResult(goiDichVuService.updateGoiDichVu(id,request));
        apiResponse.setMessage("Cập nhật thành công");
        return  apiResponse;
    }
}
