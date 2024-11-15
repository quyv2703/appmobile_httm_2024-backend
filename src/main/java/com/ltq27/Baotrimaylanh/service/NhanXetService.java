package com.ltq27.Baotrimaylanh.service;

import com.ltq27.Baotrimaylanh.dto.request.customer.NhanXetDTO;
import com.ltq27.Baotrimaylanh.dto.response.NhanXetResponseDTO;
import com.ltq27.Baotrimaylanh.entity.Customer;
import com.ltq27.Baotrimaylanh.entity.GoiDichVu;
import com.ltq27.Baotrimaylanh.entity.NhanXet;
import com.ltq27.Baotrimaylanh.repository.CustomerRepository;
import com.ltq27.Baotrimaylanh.repository.GoiDichVuRepository;
import com.ltq27.Baotrimaylanh.repository.NhanXetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NhanXetService {
    @Autowired
    private NhanXetRepository nhanXetRepository;
    @Autowired
    private GoiDichVuRepository goiDichVuRepository;
    @Autowired
    private CustomerRepository customerRepository;

    public NhanXetResponseDTO addNhanXet(NhanXetDTO nhanXetDTO) {
        GoiDichVu goiDichVu = goiDichVuRepository.findById(nhanXetDTO.getGoiDichVuId()).orElseThrow(() -> new RuntimeException("Gói dịch vụ không tồn tại"));
        Customer customer = customerRepository.findById(nhanXetDTO.getCustomerId()).orElseThrow(() -> new RuntimeException("Khách hàng không tồn tại"));

        NhanXet nhanXet = new NhanXet();
        nhanXet.setGoiDichVu(goiDichVu);
        nhanXet.setCustomer(customer);
        nhanXet.setStart(nhanXetDTO.getStart());
        nhanXet.setComment(nhanXetDTO.getComment());
        nhanXet.setLabel(nhanXetDTO.getLabel());
        NhanXet savedNhanXet= nhanXetRepository.save(nhanXet);
        return new NhanXetResponseDTO(
                customer.getName(),
                goiDichVu.getName(),
                savedNhanXet.getStart(),
                savedNhanXet.getComment(),
                savedNhanXet.getLabel()
        );
    }

    public List<NhanXetResponseDTO> getNhanXetByGoiDichVu(Long goiDichVuId) {
       List<NhanXet> nhanXetList=nhanXetRepository.findByGoiDichVuId(goiDichVuId);
       return nhanXetList.stream().map(nhanXet ->
           new NhanXetResponseDTO(
                  nhanXet.getCustomer().getName(),
                   nhanXet.getGoiDichVu().getName(),
                   nhanXet.getStart(),
                   nhanXet.getComment(),
                   nhanXet.getLabel()
           )
       ).collect(Collectors.toList());
    }
    public List<NhanXetResponseDTO> getNhanXetByLabel(String label) {
        List<NhanXet> nhanXetList = nhanXetRepository.findByLabel(label);

        // Chuyển đổi danh sách NhanXet thành danh sách NhanXetResponseDTO
        return nhanXetList.stream().map(nhanXet ->
                new NhanXetResponseDTO(
                        nhanXet.getCustomer().getName(),
                        nhanXet.getGoiDichVu().getName(),
                        nhanXet.getStart(),
                        nhanXet.getComment(),
                        nhanXet.getLabel()
                )
        ).collect(Collectors.toList());
    }


    public Optional<NhanXet> getNhanXet(Long id) {
        return nhanXetRepository.findById(id);
    }

    public void deleteNhanXet(Long id) {
        nhanXetRepository.deleteById(id);
    }
}
