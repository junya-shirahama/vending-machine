package com.practice.service;

import com.practice.DrinkBean;
import com.practice.entity.Drink;
import com.practice.repository.DrinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by JunyaShirahama on 2018/01/29.
 */
@Service
public class PurchaseService {

    @Autowired
    private DrinkRepository drinkRepository;

    public DrinkBean getPurchasableDrinkList() {
        List<Drink> drinkList = drinkRepository.findAll();
        DrinkBean drinkBean = new DrinkBean(drinkList);
        return drinkBean;
    }

    public int calculateChange(int drinkId, int money) {
        Drink drink = drinkRepository.findById(drinkId)
                .orElseThrow(() -> new IllegalArgumentException("指定されたIDの飲み物は存在しません。"));
        int change = money - drink.getPrice();
        return change;
    }
}
