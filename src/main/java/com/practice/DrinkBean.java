package com.practice;

import com.practice.entity.Drink;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

/**
 * @author JunyaShirahama
 */
@AllArgsConstructor
@Getter
public class DrinkBean {

    private List<Drink> drinkList;
}
