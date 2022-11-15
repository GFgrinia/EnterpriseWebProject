package com.academy.repository;

import com.academy.model.CarStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarStatusRepository extends JpaRepository<CarStatus, Integer> {
    CarStatus findByStatus(String status);

    // TODO: DELETE THIS
    default CarStatus findByStatusSlow(String status) {
        simulateSlowService();
        return findByStatus(status);
    }


    private void simulateSlowService() {
        try {
            long time = 5000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}
