package com.ltq27.Baotrimaylanh.service;

import com.ltq27.Baotrimaylanh.dto.request.employee.DonGiaDTO;
import com.ltq27.Baotrimaylanh.entity.DonGia;
import com.ltq27.Baotrimaylanh.entity.GoiDichVu;
import com.ltq27.Baotrimaylanh.entity.LoaiMayLanh;
import com.ltq27.Baotrimaylanh.repository.DonGiaRepository;
import com.ltq27.Baotrimaylanh.repository.GoiDichVuRepository;
import com.ltq27.Baotrimaylanh.repository.LoaiMayLanhRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DonGiaService {
    @Autowired
    private DonGiaRepository donGiaRepository;
    @Autowired
    private GoiDichVuRepository goiDichVuRepository;
    @Autowired
    private LoaiMayLanhRepository loaiMayLanhRepository;

    public List<DonGia> getAllDonGia() {
        return donGiaRepository.findAll();
    }
    public Optional<Long> getDonGiaByGoiDichVuIdAndLoaiMayLanhId(Long goiDichVuId, Long loaiMayLanhId) {
        return donGiaRepository.findIdByGoiDichVuIdAndLoaiMayLanhId(goiDichVuId, loaiMayLanhId);
    }
    public List<LoaiMayLanh> getLoaiMayLanhByGoiDichVuId(Long goiDichVuId) {
        List<DonGia> donGiaList = donGiaRepository.findByGoiDichVuId(goiDichVuId);
        return donGiaList.stream()
                .map(DonGia::getLoaiMayLanh)
                .distinct()
                .collect(Collectors.toList());
    }

    public Optional<DonGia> getDonGiaById(Long id) {
        return donGiaRepository.findById(id);
    }

    public DonGia saveDonGia(DonGiaDTO donGiaDTO) {
        GoiDichVu goiDichVu= goiDichVuRepository.findById(donGiaDTO.getGoiDichVuId())
                .orElseThrow(()->new RuntimeException("Không tìm thấy gói dịch vụ"));
        LoaiMayLanh loaiMayLanh=loaiMayLanhRepository.findById(donGiaDTO.getLoaiMayLanhId())
                .orElseThrow(()->new RuntimeException("Không tìm thấy loại máy lạnh"));
        DonGia donGia= new DonGia();
        donGia.setGoiDichVu(goiDichVu);
        donGia.setLoaiMayLanh(loaiMayLanh);
        donGia.setPrice(donGiaDTO.getPrice());
        return donGiaRepository.save(donGia);
    }

    public void deleteDonGia(Long id) {
        donGiaRepository.deleteById(id);
    }
    public Optional<DonGia> updateDonGia(Long id, DonGia updatedDonGia) {
        return donGiaRepository.findById(id).map(existingDonGia -> {

            existingDonGia.setPrice(updatedDonGia.getPrice());
            return donGiaRepository.save(existingDonGia);
        });
    }
}
