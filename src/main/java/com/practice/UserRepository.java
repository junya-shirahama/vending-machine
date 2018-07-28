package com.practice;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author JunyaShirahama
 */
public interface UserRepository extends JpaRepository<User, String> {
}
