package com.ltq27.Baotrimaylanh.controller;

import com.ltq27.Baotrimaylanh.dto.ServiceWithPriceRange;
import com.ltq27.Baotrimaylanh.dto.request.ApiResponse;

import com.ltq27.Baotrimaylanh.entity.DichVu;
import com.ltq27.Baotrimaylanh.service.DichVuService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/dichvu")
public class DichVuController {
    @Autowired
    private DichVuService dichVuService;

    @PostMapping
    public ApiResponse<DichVu> createDichVu(@RequestBody  DichVu request){
        ApiResponse<DichVu> apiResponse= new ApiResponse<>();
        apiResponse.setMessage("Tạo dịch vụ thành công");
        apiResponse.setResult(dichVuService.createDichVu(request));
        return apiResponse;
    }
    @GetMapping
    public ApiResponse<List<ServiceWithPriceRange>> getListDichVu(){
        List<ServiceWithPriceRange> dichVuList=dichVuService.getListDichVu();
        ApiResponse<List<ServiceWithPriceRange>> apiResponse= new ApiResponse<>();
        apiResponse.setMessage("Danh sách dịch vụ");
        apiResponse.setResult(dichVuList);
        return apiResponse;
    }
    @GetMapping("/{id}")
    public ApiResponse<DichVu> getDichVu(@PathVariable Long id){
        Optional<DichVu> dichVu=dichVuService.getDichVu(id);
        ApiResponse<DichVu> apiResponse= new ApiResponse<>();
        if(dichVu.isPresent()){
            apiResponse.setResult(dichVu.get());
            apiResponse.setMessage("Lấy thành công dịch vụ");
        }else {
            // Bạn có thể tùy chỉnh thông báo lỗi và mã lỗi tại đây
            apiResponse.setMessage("Dịch vụ không tồn tại");
            apiResponse.setCode(HttpStatus.NOT_FOUND.value());
        }

        return apiResponse;
    }
    @PutMapping("/{id}")
    public ApiResponse<DichVu> updateDichVu(@PathVariable Long id, @RequestBody DichVu request){
        ApiResponse<DichVu> apiResponse= new ApiResponse<>();
        apiResponse.setResult(dichVuService.updateDichVu(id,request));
        return apiResponse;
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteDichVu(@PathVariable Long id) {
        ApiResponse<Void> apiResponse = new ApiResponse<>();
        try {
            DichVu deletedDichVu = dichVuService.deleteDichVu(id);
            apiResponse.setMessage("Xóa thành công dịch vụ với id: " + id);
            apiResponse.setResult(null); // Không có kết quả trả về
        } catch (RuntimeException e) {
            apiResponse.setMessage(e.getMessage());
            apiResponse.setResult(null);
        }
        return apiResponse;
    }
}
