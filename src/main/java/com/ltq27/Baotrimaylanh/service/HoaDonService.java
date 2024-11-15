package com.ltq27.Baotrimaylanh.service;

import com.ltq27.Baotrimaylanh.dto.request.employee.BaoCaoDoanhThuAll;
import com.ltq27.Baotrimaylanh.entity.HoaDon;
import com.ltq27.Baotrimaylanh.repository.HoaDonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class HoaDonService {
    @Autowired
    private HoaDonRepository hoaDonRepository;

    public HoaDon updateTrangThaiThanhToan(Long id) {
        HoaDon hoaDon = hoaDonRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy hóa đơn với id: " + id));
        hoaDon.setTrangThaiThanhToan(1);
        hoaDon.setNgayThanhToan(LocalDate.now());
        return hoaDonRepository.save(hoaDon);
    }
    public List<HoaDon> getHoaDonsByCustomerId(Long customerId) {
        return hoaDonRepository.findByThongTinDatLich_Customer_Id(customerId);
    }
    public Double getTotalRevenue(LocalDate startDate, LocalDate endDate) {
        return hoaDonRepository.calculateTotalRevenue(startDate, endDate);
    }
    public BaoCaoDoanhThuAll getRevenueReport(LocalDate startDate, LocalDate endDate) {
        Double tongDoanhThu = hoaDonRepository.calculateTotalRevenue(startDate, endDate);
        Long tongHoaDonDaThanhToan = hoaDonRepository.countTotalInvoices(startDate, endDate);

        Long soHoaDonChuaThanhToan = hoaDonRepository.countByPaymentStatus(0);

        BaoCaoDoanhThuAll baoCao = new BaoCaoDoanhThuAll();
        baoCao.setTongDoanhThu(tongDoanhThu);
        baoCao.setTongHoaDonDaThanhToan(tongHoaDonDaThanhToan);

        baoCao.setSoHoaDonChuaThanhToan(soHoaDonChuaThanhToan);

        return baoCao;
    }
    @Transactional
    public void deleteHoaDonByThongTinDatLichId(Long thongTinDatLichId) {
        HoaDon hoaDon = hoaDonRepository.findByThongTinDatLich_Id(thongTinDatLichId)
                .orElseThrow(() -> new RuntimeException("HoaDon not found with ThongTinDatLich id: " + thongTinDatLichId));
        hoaDonRepository.delete(hoaDon);
    }
}
