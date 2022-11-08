package com.academy.repository;

import com.academy.model.Car;
import com.academy.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestRepository extends JpaRepository<Request, Integer> {
    @Query("select c from Car c where c.carStatus.status = :status")
    List<Car> findByStatus(@Param("status") String status);

    @Query("select r from Request r where r.requestStatus.id = :status")
    List<Request> findRequestByStatus(@Param("status") Integer status);
}
