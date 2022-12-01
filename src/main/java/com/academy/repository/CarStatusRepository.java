package com.academy.repository;

import com.academy.model.CarStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarStatusRepository extends JpaRepository<CarStatus, Integer> {
    CarStatus findByStatus(String status);
}
