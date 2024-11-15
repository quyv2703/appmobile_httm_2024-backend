package com.ltq27.Baotrimaylanh.repository;

import com.ltq27.Baotrimaylanh.entity.HoaDon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface HoaDonRepository extends JpaRepository<HoaDon, Long> {
    @Query("SELECT SUM(h.tongTien) FROM HoaDon h WHERE h.ngayThanhToan IS NOT NULL")
    Double findTotalRevenue();

    @Query("SELECT COUNT(h.id) FROM HoaDon h WHERE h.ngayThanhToan IS NOT NULL")
    Long findTotalPaidInvoices();

    @Query("SELECT COUNT(h.id) FROM HoaDon h WHERE h.trangThaiThanhToan = :status")
    Long countByPaymentStatus(@Param("status") int status);
    // xem hóa đơn của khách hàng
    List<HoaDon> findByThongTinDatLich_Customer_Id(Long customerId);
    // xem doanh thu trong khoảng thời gian
    @Query("SELECT SUM(h.tongTien) FROM HoaDon h WHERE h.ngayThanhToan BETWEEN :startDate AND :endDate")
    Double calculateTotalRevenue(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
    @Query("SELECT COUNT(h) FROM HoaDon h WHERE h.ngayThanhToan BETWEEN :startDate AND :endDate")
    Long countTotalInvoices(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    @Query("SELECT COUNT(h) FROM HoaDon h WHERE h.ngayThanhToan BETWEEN :startDate AND :endDate AND h.trangThaiThanhToan = 1")
    Long countPaidInvoices(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    @Query("SELECT COUNT(h) FROM HoaDon h WHERE h.ngayThanhToan BETWEEN :startDate AND :endDate AND h.trangThaiThanhToan = 0")
    Long countUnpaidInvoices(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
    void deleteByThongTinDatLich_Id(Long thongTinDatLichId);
    Optional<HoaDon> findByThongTinDatLich_Id(Long thongTinDatLichId);
}