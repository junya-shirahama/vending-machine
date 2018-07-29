package com.practice.service;

import com.practice.entity.Drink;
import com.practice.form.DrinkForm;
import com.practice.repository.DrinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author JunyaShirahama
 */
@Service
public class DrinkService {

    @Autowired
    private DrinkRepository drinkRepository;

    public List<Drink> getAllDrink() {
        return drinkRepository.findAll();
    }

    public void addDrink(DrinkForm form) {
        Drink drink = new Drink();
        drink.setDrinkName(form.getDrinkName());
        drink.setPrice(form.getPrice());
        drinkRepository.save(drink);
    }

    public Drink getDrinkById(int id) {
        return drinkRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("指定されたIDが存在しません。"));
    }
}
