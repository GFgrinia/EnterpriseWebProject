package com.academy.repository;

import com.academy.model.Payment;
import com.academy.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

    @Query("select r from Payment r where r.paymentStatus.status = :status")
    List<Payment> findPaymentByStatus(@Param("status") String status);

    @Query("select r from Payment r where r.request.user.id = :userId")
    List<Payment> findPaymentByUser(@Param("userId") Integer userId);

    @Query("select r from Payment r where r.request.user.id = :userId and r.paymentStatus.status = :status")
    List<Payment> findPaymentByUserAndPaymentStatus(@Param("userId") Integer userId, @Param("status") String status);

    Payment findPaymentByRequest(Request request);

}
