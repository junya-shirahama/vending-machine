package com.practice.repository;

import com.practice.entity.Drink;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author JunyaShirahama
 */
public interface DrinkRepository extends JpaRepository<Drink, Integer> {
}
