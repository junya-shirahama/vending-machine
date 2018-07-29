package com.practice.controller;

import com.practice.entity.Drink;
import com.practice.repository.DrinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author JunyaShirahama
 */
@Controller
public class DrinkContller {

    @Autowired
    private DrinkRepository drinkRepository;

    @RequestMapping(value = "drink", method = RequestMethod.GET)
    public ModelAndView drink(ModelAndView mav) {
        List<Drink> drinkList = drinkRepository.findAll();
        mav.addObject("drinkList", drinkList);
        mav.setViewName("drink");
        return mav;
    }
}
