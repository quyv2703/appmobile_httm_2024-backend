package com.ltq27.Baotrimaylanh.service;

import com.ltq27.Baotrimaylanh.dto.request.customer.GoiDichVuDTO;
import com.ltq27.Baotrimaylanh.dto.request.customer.LoaiMayLanhGiaDTO;
import com.ltq27.Baotrimaylanh.entity.DonGia;
import com.ltq27.Baotrimaylanh.entity.GoiDichVu;
import com.ltq27.Baotrimaylanh.repository.DonGiaRepository;
import com.ltq27.Baotrimaylanh.repository.GoiDichVuRepository;
import com.ltq27.Baotrimaylanh.repository.LoaiMayLanhRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GoiDichVuService {
    @Autowired
    private GoiDichVuRepository goiDichVuRepository;
    @Autowired
    private DonGiaRepository donGiaRepository;
    @Autowired
    private LoaiMayLanhRepository loaiMayLanhRepository;

    public GoiDichVu createGoiDichVu(GoiDichVu goiDichVu){
        return goiDichVuRepository.save(goiDichVu);
    }
    public List<GoiDichVuDTO> getAllGoiDichVuWithPrices() {
        List<GoiDichVu> goiDichVuList = goiDichVuRepository.findAll();
        List<GoiDichVuDTO> goiDichVuDTOList = new ArrayList<>();

        for (GoiDichVu goiDichVu : goiDichVuList) {
            GoiDichVuDTO goiDichVuDTO = new GoiDichVuDTO();
            goiDichVuDTO.setGoiDichVuId(goiDichVu.getId());
            goiDichVuDTO.setTenGoi(goiDichVu.getName());
            goiDichVuDTO.setDescription(goiDichVu.getDescription());

            List<LoaiMayLanhGiaDTO> loaiMayLanhGiaList = new ArrayList<>();
            List<DonGia> donGiaList = donGiaRepository.findByGoiDichVu(goiDichVu);

            for (DonGia donGia : donGiaList) {
                LoaiMayLanhGiaDTO loaiMayLanhGiaDTO = new LoaiMayLanhGiaDTO();
                loaiMayLanhGiaDTO.setLoaiMayLanhId(donGia.getLoaiMayLanh().getId());
                loaiMayLanhGiaDTO.setTenLoaiMayLanh(donGia.getLoaiMayLanh().getName());
                loaiMayLanhGiaDTO.setGia(donGia.getPrice());
                loaiMayLanhGiaList.add(loaiMayLanhGiaDTO);
            }

            goiDichVuDTO.setLoaiMayLanhGiaList(loaiMayLanhGiaList);
            goiDichVuDTOList.add(goiDichVuDTO);
        }

        return goiDichVuDTOList;
    }
    public List<GoiDichVu> getAllGoiDichVu(){
        return goiDichVuRepository.findAll();
    }
    public GoiDichVu deleteGoiDichVu(Long id){
        goiDichVuRepository.deleteById(id);
        return null;
    }
    public Optional<GoiDichVu> getById(Long id){
        return goiDichVuRepository.findById(id);
    }
    public GoiDichVu updateGoiDichVu(Long id, GoiDichVu goiDichVu){
        GoiDichVu goiDv=goiDichVuRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Không tìm thấy gói dịch vụ"));
        goiDv.setName(goiDichVu.getName());

        goiDv.setDescription(goiDichVu.getDescription());


        return goiDichVuRepository.save(goiDv);
    }
}
