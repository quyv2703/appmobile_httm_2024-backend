package com.ltq27.Baotrimaylanh.service;

import com.ltq27.Baotrimaylanh.entity.LoaiMayLanh;
import com.ltq27.Baotrimaylanh.repository.LoaiMayLanhRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class LoaiMayLanhService {
    @Autowired
    private LoaiMayLanhRepository loaiMayLanhRepository;
    public LoaiMayLanh createLoaiMayLanh(LoaiMayLanh loaiMayLanh){
        return loaiMayLanhRepository.save(loaiMayLanh);
    }
    public List<LoaiMayLanh> loaiMayLanhList(){
        return loaiMayLanhRepository.findAll();
    }
    public void deleteLoaiMayLanh(Long id){
        loaiMayLanhRepository.deleteById(id);
    }

    public LoaiMayLanh updateLoaiMayLanh(Long id, LoaiMayLanh updateLoaiMayLanh) {
        LoaiMayLanh loaiMayLanh=loaiMayLanhRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Không tìm thấy loại máy lạnh với id: "+id));
        loaiMayLanh.setName(updateLoaiMayLanh.getName());
        return loaiMayLanhRepository.save(loaiMayLanh);
    }
    public LoaiMayLanh getByName(String name){
        return loaiMayLanhRepository.findByName(name);
    }
    public Optional<LoaiMayLanh> getByIdLoaiMayLanh(Long id){
        return loaiMayLanhRepository.findById(id);
    }

    private void loaiMayLanh(String name) {
    }


}
