package com.academy.repository;

import com.academy.model.Login;
import com.academy.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<Login, Integer> {

    Login findByUser(User user);
}
