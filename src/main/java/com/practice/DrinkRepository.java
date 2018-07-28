package com.practice;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author JunyaShirahama
 */
public interface DrinkRepository extends JpaRepository<Drink, Integer> {
}
