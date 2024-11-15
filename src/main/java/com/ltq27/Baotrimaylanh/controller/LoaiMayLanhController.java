package com.ltq27.Baotrimaylanh.controller;

import com.ltq27.Baotrimaylanh.dto.request.ApiResponse;
import com.ltq27.Baotrimaylanh.entity.LoaiMayLanh;
import com.ltq27.Baotrimaylanh.service.LoaiMayLanhService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/loaimaylanh")
public class LoaiMayLanhController {
    @Autowired
    private LoaiMayLanhService loaiMayLanhService;


  @GetMapping
  public ApiResponse<List<LoaiMayLanh>> getAllLoaiMayLanh() {
      List<LoaiMayLanh> loaiMayLanhList = loaiMayLanhService.loaiMayLanhList();
      ApiResponse<List<LoaiMayLanh>> response = new ApiResponse<>();

      response.setMessage("Danh sách loại máy lạnh được lấy thành công");
      response.setResult(loaiMayLanhList);
      return response;
  }
  @GetMapping("/{id}")
  public ApiResponse<Optional<LoaiMayLanh>> getByIdLoaiMayLanh(@PathVariable Long id){
      ApiResponse<Optional<LoaiMayLanh>> apiResponse= new ApiResponse<>();
      apiResponse.setMessage("");
      apiResponse.setResult(loaiMayLanhService.getByIdLoaiMayLanh(id));
      return apiResponse;
  }
  @GetMapping("/{name}")
  public ApiResponse<LoaiMayLanh> getByNameLoaiMayLanh(@PathVariable String name){
      ApiResponse<LoaiMayLanh> apiResponse= new ApiResponse<>();
      apiResponse.setMessage("");
      apiResponse.setResult(loaiMayLanhService.getByName(name));
      return apiResponse;
  }

    @PostMapping
    public ApiResponse<LoaiMayLanh> createLoaiMayLanh(@RequestBody LoaiMayLanh loaiMayLanh) {
        LoaiMayLanh createdLoaiMayLanh = loaiMayLanhService.createLoaiMayLanh(loaiMayLanh);
        ApiResponse<LoaiMayLanh> response = new ApiResponse<>();

        response.setMessage("Loại máy lạnh được tạo thành công");
        response.setResult(createdLoaiMayLanh);
        return response;
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteLoaiSach(@PathVariable Long id) {
        loaiMayLanhService.deleteLoaiMayLanh(id);
        ApiResponse<Void> response = new ApiResponse<>();

        response.setMessage("Loại máy lạnh được xóa thành công");
        return response;
    }
    @PutMapping("/{id}")
    public ApiResponse<Void> updateLoaiMayLanh(@PathVariable Long id,@RequestBody LoaiMayLanh loaiMayLanh) {
        loaiMayLanhService.updateLoaiMayLanh(id,loaiMayLanh);
        ApiResponse<Void> response = new ApiResponse<>();
        response.setMessage("Loại máy lạnh được cập nhật thành công");
        return response;
    }

}
