package com.ltq27.Baotrimaylanh.service;

import com.ltq27.Baotrimaylanh.entity.Employee;
import com.ltq27.Baotrimaylanh.entity.PhanCong;
import com.ltq27.Baotrimaylanh.entity.ThongTinDatLich;
import com.ltq27.Baotrimaylanh.repository.EmployeeRepository;
import com.ltq27.Baotrimaylanh.repository.PhanCongRepository;
import com.ltq27.Baotrimaylanh.repository.ThongTinDatLichRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ltq27.Baotrimaylanh.mapper.TrangThaiPhanCong;

import java.util.Date;
import java.util.List;

@Service
public class PhanCongService {
    @Autowired
    private PhanCongRepository phanCongRepository;

    @Autowired
    private ThongTinDatLichRepository thongTinDatLichRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    public PhanCong taoPhanCong(Long maDatLich, Long maNhanVien) {
        ThongTinDatLich thongTinDatLich = thongTinDatLichRepository.findById(maDatLich)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy thông tin đặt lịch"));

        Employee employee = employeeRepository.findById(maNhanVien)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy nhân viên"));

        PhanCong phanCong = new PhanCong();
        phanCong.setThongTinDatLich(thongTinDatLich);
        phanCong.setNhanVien(employee);
        phanCong.setTrangThai(TrangThaiPhanCong.CHO_XAC_NHAN);

        return phanCongRepository.save(phanCong);
    }

    @Transactional
    public PhanCong capNhatTrangThaiPhanCong(Long phanCongId, TrangThaiPhanCong trangThai) {
        PhanCong phanCong = phanCongRepository.findById(phanCongId)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy phân công"));

        phanCong.setTrangThai(trangThai);


        return phanCongRepository.save(phanCong);
    }
    public PhanCong updateNhanVienVaTrangThai(Long phanCongId, Long maNhanVienMoi) {
        PhanCong phanCong = phanCongRepository.findById(phanCongId)
                .orElseThrow(() -> new RuntimeException("PhanCong not found with id " + phanCongId));

        Employee nhanVienMoi = employeeRepository.findById(maNhanVienMoi)
                .orElseThrow(() -> new RuntimeException("Employee not found with id " + maNhanVienMoi));

        phanCong.setNhanVien(nhanVienMoi);
        phanCong.setTrangThai(TrangThaiPhanCong.CHO_XAC_NHAN);
        return phanCongRepository.save(phanCong);
    }

    public List<PhanCong> layDanhSachPhanCongTheoNhanVien(Long maNhanVien) {
        return phanCongRepository.findByNhanVienId(maNhanVien);
    }
    // Phương thức để lấy danh sách phân công theo trạng thái
    public List<PhanCong> getPhanCongByTrangThai(TrangThaiPhanCong trangThai) {
        return phanCongRepository.findByTrangThai(trangThai);
    }
}
