package com.ltq27.Baotrimaylanh.service;

import com.ltq27.Baotrimaylanh.dto.ServiceWithPriceRange;
import com.ltq27.Baotrimaylanh.entity.DichVu;
import com.ltq27.Baotrimaylanh.entity.GiaDichVu;
import com.ltq27.Baotrimaylanh.repository.DichVuRepository;
import com.ltq27.Baotrimaylanh.repository.GiaDichVuRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DichVuService {
    @Autowired
    private DichVuRepository dichVuRepository;
    @Autowired
    private GiaDichVuRepository giaDichVuRepository;

    public DichVu createDichVu( DichVu request){

        return dichVuRepository.save(request);
    }

    public List<ServiceWithPriceRange> getListDichVu(){
        List<DichVu> dichVuList=dichVuRepository.findAll();
        return dichVuList.stream().map(this::mapToServiceWithPriceRange).collect(Collectors.toList());
    }
    private ServiceWithPriceRange mapToServiceWithPriceRange(DichVu dichVu){
        if (dichVu.getIsFixedPrice()) {
            return new ServiceWithPriceRange(dichVu, dichVu.getCommonPrice(), dichVu.getCommonPrice());
        } else {
            List<GiaDichVu> servicePrices = giaDichVuRepository.findByDichVu(dichVu);
            if(servicePrices.isEmpty()){
                return  new ServiceWithPriceRange(dichVu,"0","0");

             }
            double minPrice = servicePrices.stream()
                    .mapToDouble(sp -> parsePrice(sp.getPrice()))
                    .min()
                    .orElse(0);
            double maxPrice = servicePrices.stream()
                    .mapToDouble(sp -> parsePrice(sp.getPrice()))
                    .max()
                    .orElse(0);
            return new ServiceWithPriceRange(dichVu, formatPrice(minPrice), formatPrice(maxPrice));
        }
    }
    private double parsePrice(String price) {
        // Loại bỏ các ký tự không phải số và dấu thập phân
        String cleanedPrice = price.replaceAll("[^\\d.]", "");
        return Double.parseDouble(cleanedPrice);
    }

    private String formatPrice(double price) {
        // Định dạng lại giá trị thành chuỗi với định dạng 0,000.00
        return String.format("%,.2f", price);
    }

    public DichVu deleteDichVu(Long id) {
        Optional<DichVu> dichVuOptional = dichVuRepository.findById(id);
        if (dichVuOptional.isPresent()) {
            dichVuRepository.deleteById(id);

        } else {
            throw new RuntimeException("Không tìm thấy dịch vụ với id: " + id); // Hoặc xử lý theo cách khác
        }
        return null;
    }

    public DichVu updateDichVu(Long id, DichVu dv){
        DichVu dichVu= dichVuRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Dich Vu not found"));
        dichVu.setName(dv.getName());
        return dichVuRepository.save(dichVu);
    }

    public Optional<DichVu> getDichVu(Long id){
        return  dichVuRepository.findById(id);
    }
}
