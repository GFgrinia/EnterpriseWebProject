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

    @Query("select r from Request r where r.requestStatus.status = :status")
    List<Request> findRequestByStatus(@Param("status") String status);

    @Query("select r from Request r where r.user.id = :userId")
    List<Request> findRequestByUser(@Param("userId") Integer userId);

    @Query("select r from Request r where r.user.id = :userId and r.requestStatus.status = :status")
    List<Request> findRequestByUserAndRequestStatus(@Param("userId") Integer userId, @Param("status") String status);
}
