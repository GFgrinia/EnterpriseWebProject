package com.academy.repository;

import com.academy.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {
    @Query("select c from Car c where c.carStatus.status = :status")
    List<Car> findCarsByStatus(@Param("status") String status);
}
