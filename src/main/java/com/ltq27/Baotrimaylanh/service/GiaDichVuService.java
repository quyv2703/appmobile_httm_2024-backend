package com.ltq27.Baotrimaylanh.service;

import com.ltq27.Baotrimaylanh.dto.request.employee.GiaDichVuDto;
import com.ltq27.Baotrimaylanh.entity.DichVu;
import com.ltq27.Baotrimaylanh.entity.GiaDichVu;
import com.ltq27.Baotrimaylanh.entity.LoaiMayLanh;
import com.ltq27.Baotrimaylanh.repository.DichVuRepository;
import com.ltq27.Baotrimaylanh.repository.GiaDichVuRepository;
import com.ltq27.Baotrimaylanh.repository.LoaiMayLanhRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class GiaDichVuService {
    @Autowired
    private GiaDichVuRepository giaDichVuRepository;
    @Autowired
    private DichVuRepository dichVuRepository;
    @Autowired
    private LoaiMayLanhRepository loaiMayLanhRepository;
    @Transactional
    public GiaDichVu createGiaDichVu(GiaDichVuDto dto){
        DichVu dichVu = dichVuRepository.findById(dto.getIdDv())
                .orElseThrow(()-> new RuntimeException("Không tìm thấy loại dịch vụ "));
        LoaiMayLanh loaiMayLanh=loaiMayLanhRepository.findById(dto.getIdLml())
                .orElseThrow(()-> new RuntimeException("Không tìm thấy loại máy lạnh"));
        if(giaDichVuRepository.existsByDichVuAndLoaiMayLanh(dichVu,loaiMayLanh)){
            throw new RuntimeException("Giá cho dịch vụ và loại máy lạnh này đã tồn tại");
        }
        GiaDichVu giaDichVu = new GiaDichVu();
        giaDichVu.setDichVu(dichVu);
        giaDichVu.setLoaiMayLanh(loaiMayLanh);
        giaDichVu.setPrice(dto.getPrice());
        return giaDichVuRepository.save(giaDichVu);
    }
    public String getGiaDichVu(Long dichVuId,Long loaiMLId) {
        Optional<DichVu> dichVuOptional=dichVuRepository.findById(dichVuId);
        if(dichVuOptional.isPresent()){
            DichVu dichVu=dichVuOptional.get();
            if(dichVu.getIsFixedPrice()){
                return dichVu.getCommonPrice();
            }else {
                LoaiMayLanh loai=loaiMayLanhRepository.findById(loaiMLId).orElse(null);
                if(loai!=null){
                    GiaDichVu giaDichVu=giaDichVuRepository.findByDichVuAndLoaiMayLanh(dichVu,loai);
                    return (giaDichVu!=null) ? giaDichVu.getPrice():null;
                }
            }
        }
        return null;
    }

    public List<GiaDichVu> getAllGiaDichVu() {
        return giaDichVuRepository.findAll();
    }

    @Transactional
    public GiaDichVu updateGiaDichVu(Long id, GiaDichVuDto dto) {
        GiaDichVu giaDichVu = giaDichVuRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy giá dịch vụ với ID: " + id));

        DichVu dichVu = dichVuRepository.findById(dto.getIdDv())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy loại dịch vụ "));
        LoaiMayLanh loaiMayLanh = loaiMayLanhRepository.findById(dto.getIdLml())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy loại máy lạnh"));

        if (giaDichVuRepository.existsByDichVuAndLoaiMayLanh(dichVu, loaiMayLanh) && !giaDichVu.getId().equals(id)) {
            throw new RuntimeException("Giá cho dịch vụ và loại máy lạnh này đã tồn tại");
        }

        giaDichVu.setDichVu(dichVu);
        giaDichVu.setLoaiMayLanh(loaiMayLanh);
        giaDichVu.setPrice(dto.getPrice());
        return giaDichVuRepository.save(giaDichVu);
    }
    @Transactional
    public void deleteGiaDichVu(Long id) {
        GiaDichVu giaDichVu = giaDichVuRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy giá dịch vụ với ID: " + id));
        giaDichVuRepository.delete(giaDichVu);
    }



}
