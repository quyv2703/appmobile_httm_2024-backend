package com.ltq27.Baotrimaylanh.controller;

import com.ltq27.Baotrimaylanh.dto.request.ApiResponse;
import com.ltq27.Baotrimaylanh.dto.request.employee.BaoCaoDoanhThuAll;
import com.ltq27.Baotrimaylanh.entity.HoaDon;
import com.ltq27.Baotrimaylanh.service.HoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping("/api/hoadon")
public class HoaDonController {
    @Autowired
    private HoaDonService hoaDonService;

    @PatchMapping("/{id}")
    public ApiResponse<HoaDon> updateHoaDon(@PathVariable Long id){
        ApiResponse<HoaDon> apiResponse= new ApiResponse<>();
        HoaDon hoaDon=hoaDonService.updateTrangThaiThanhToan(id);
        apiResponse.setMessage("Cập nhật hóa đơn thành công");
        apiResponse.setResult(hoaDon);
        return apiResponse;
    }

    @GetMapping("/customer/{customerId}")
    public List<HoaDon> getHoaDonsByCustomerId(@PathVariable Long customerId) {
        return hoaDonService.getHoaDonsByCustomerId(customerId);
    }
    @GetMapping("/report/revenue")
    public BaoCaoDoanhThuAll getRevenueReport(@RequestParam("startDate") LocalDate startDate,
                                              @RequestParam("endDate") LocalDate endDate) {
        return hoaDonService.getRevenueReport(startDate, endDate);
    }

    @DeleteMapping("/delete-by-thongtindatlich/{thongTinDatLichId}")
    public ResponseEntity<?> deleteHoaDonByThongTinDatLichId(@PathVariable Long thongTinDatLichId) {
        hoaDonService.deleteHoaDonByThongTinDatLichId(thongTinDatLichId);
        return ResponseEntity.ok("HoaDon with ThongTinDatLich ID " + thongTinDatLichId + " deleted successfully.");
    }
}
