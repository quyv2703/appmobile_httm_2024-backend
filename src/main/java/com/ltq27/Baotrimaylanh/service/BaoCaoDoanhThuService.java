package com.ltq27.Baotrimaylanh.service;

import com.ltq27.Baotrimaylanh.dto.request.employee.BaoCaoDoanhThuAll;
import com.ltq27.Baotrimaylanh.repository.HoaDonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaoCaoDoanhThuService {

    @Autowired
    private HoaDonRepository hoaDonRepository;

    public BaoCaoDoanhThuAll taoBaoCaoDoanhThu() {
        Double tongDoanhThu = hoaDonRepository.findTotalRevenue();
        Long tongHoaDonDaThanhToan = hoaDonRepository.findTotalPaidInvoices();
        Long soHoaDonChuaThanhToan = hoaDonRepository.countByPaymentStatus(0); // Giả sử 0 là chưa thanh toán


        BaoCaoDoanhThuAll baoCao = new BaoCaoDoanhThuAll();
        baoCao.setTongDoanhThu(tongDoanhThu != null ? tongDoanhThu : 0.0);
        baoCao.setTongHoaDonDaThanhToan(tongHoaDonDaThanhToan);
        baoCao.setSoHoaDonChuaThanhToan(soHoaDonChuaThanhToan);


        return baoCao;
    }
}