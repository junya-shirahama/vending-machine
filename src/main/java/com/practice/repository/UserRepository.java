package com.practice.repository;

import com.practice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author JunyaShirahama
 */
public interface UserRepository extends JpaRepository<User, String> {
}
