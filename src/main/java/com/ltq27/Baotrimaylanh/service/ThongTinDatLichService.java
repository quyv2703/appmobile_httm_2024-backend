package com.ltq27.Baotrimaylanh.service;

import com.ltq27.Baotrimaylanh.dto.request.employee.DanhSachDatLichDto;
import com.ltq27.Baotrimaylanh.dto.request.employee.ThongTinDatLichDTO;
import com.ltq27.Baotrimaylanh.dto.request.employee.dto.DatLichStatusDTO;
import com.ltq27.Baotrimaylanh.entity.*;
import com.ltq27.Baotrimaylanh.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ThongTinDatLichService {

    @Autowired
    private ThongTinDatLichRepository thongTinDatLichRepository;

    @Autowired
    private HoaDonRepository lichSuHoaDonRepository;
    @Autowired
    private DonGiaRepository donGiaRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    // khách hàng xem thông tin trạng thái đặt lịch
    public List<DatLichStatusDTO> getDatLichStatus(Long customerId) {
        List<ThongTinDatLich> datLichList = thongTinDatLichRepository.findByCustomerId(customerId);
        return datLichList.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private DatLichStatusDTO convertToDTO(ThongTinDatLich thongTinDatLich) {
        return new DatLichStatusDTO(
                thongTinDatLich.getId(),
                thongTinDatLich.getNgayDat(),
                thongTinDatLich.getNgayThucHien(),
                thongTinDatLich.getDiaChiThucHien(),
                thongTinDatLich.getTrangThaiDuyet(),
                thongTinDatLich.getDonGia().getGoiDichVu().getName(),
                thongTinDatLich.getDonGia().getLoaiMayLanh().getName()
        );
    }

    public List<DanhSachDatLichDto> getAllThongTinDatLich() {
        List<ThongTinDatLich> thongTinDatLichList = thongTinDatLichRepository.findAll();

        return thongTinDatLichList.stream().map(thongTinDatLich -> {
            Long id = thongTinDatLich.getId();

            // Lấy tên khách hàng
            Customer customer = thongTinDatLich.getCustomer();
            String tenKhachHang = customer != null ? customer.getName() : "Chưa có thông tin";

            // Lấy thông tin gói dịch vụ
            DonGia donGia = thongTinDatLich.getDonGia();
            String goiDichVu = donGia != null ? donGia.getGoiDichVu().getName() : "Chưa có thông tin";

            // Ngày thực hiện
            String ngayThucHien = thongTinDatLich.getNgayThucHien().toString();

            // Địa chỉ thực hiện
            String diaChiThucHien = thongTinDatLich.getDiaChiThucHien();

            // Trạng thái duyệt
            String trangThaiDuyet = String.valueOf(thongTinDatLich.getTrangThaiDuyet());

            // Tạo và trả về DTO
            return new DanhSachDatLichDto(id, tenKhachHang, goiDichVu, ngayThucHien, diaChiThucHien, trangThaiDuyet);
        }).collect(Collectors.toList());
    }

    public Optional<ThongTinDatLich> getThongTinDatLich(Long id) {
        return thongTinDatLichRepository.findById(id);
    }

    @Transactional
    public ThongTinDatLich datLich(ThongTinDatLichDTO dto) {
        Customer customer = customerRepository.findById(dto.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Khách hàng không tồn tại"));

        DonGia donGia = donGiaRepository.findById(dto.getDonGiaId())
                .orElseThrow(() -> new RuntimeException("Đơn giá không hợp lệ"));
        /*Employee employeeManager=employeeRepository.findById(dto.getManagerId())
                .orElseThrow(()-> new RuntimeException("Quản lí không tồn tại"));*/

        ThongTinDatLich thongTinDatLich = new ThongTinDatLich();
        thongTinDatLich.setCustomer(customer);
        thongTinDatLich.setDonGia(donGia);
        // Lấy ngày hôm nay
        LocalDate ngayHomNay = LocalDate.now();
        thongTinDatLich.setNgayDat(ngayHomNay);
        thongTinDatLich.setNgayThucHien(dto.getNgayThucHien());
        thongTinDatLich.setDiaChiThucHien(dto.getDiaChiThucHien());
        thongTinDatLich.setTrangThaiDuyet(1);// 1 là chưa duyet, 2 là duyet


        HoaDon lichSuHoaDon = new HoaDon();
        lichSuHoaDon.setThongTinDatLich(thongTinDatLich);
        lichSuHoaDon.setNgayThanhToan(null);
        lichSuHoaDon.setTongTien(donGia.getPrice());

        thongTinDatLich.setLichSuHoaDon(lichSuHoaDon);

        thongTinDatLich = thongTinDatLichRepository.save(thongTinDatLich);
        lichSuHoaDonRepository.save(lichSuHoaDon);

        return thongTinDatLich;
    }

    public void deleteThongTinDatLich(Long id) {
        thongTinDatLichRepository.deleteById(id);
    }

    @Transactional
    public Optional<ThongTinDatLich> updateTrangThaiDuyet(Long id, int trangThaiDuyet) {
        return thongTinDatLichRepository.findById(id)
                .map(existingThongTinDatLich -> {
                    existingThongTinDatLich.setTrangThaiDuyet(trangThaiDuyet);
                    return thongTinDatLichRepository.save(existingThongTinDatLich);
                });
    }
    public Optional<ThongTinDatLich> updateIdManager(Long idThongTinDatLich,Long idManager){
        return thongTinDatLichRepository.findById(idThongTinDatLich)
                .map(existingThongTinDatLich ->{
                    Employee employee=employeeRepository.findById(idManager)
                                    .orElseThrow(()-> new RuntimeException("Không tìm thấy id quản lí"));
                    existingThongTinDatLich.setManagerId(employee);
                    return thongTinDatLichRepository.save(existingThongTinDatLich);
                });
    }

}