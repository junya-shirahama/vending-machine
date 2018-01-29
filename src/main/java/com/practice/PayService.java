package com.practice;

import org.springframework.stereotype.Service;

/**
 * Created by JunyaShirahama on 2018/01/29.
 */
@Service
public class PayService {

    private final int DRINK_PRICE = 120;

    public int calculateChange(int money) {
        int change = money - DRINK_PRICE;
        return change;
    }
}
