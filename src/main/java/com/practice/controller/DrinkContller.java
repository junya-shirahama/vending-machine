package com.practice.controller;

import com.practice.entity.Drink;
import com.practice.form.DrinkForm;
import com.practice.service.DrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    private DrinkService drinkService;

    @RequestMapping(value = "drink", method = RequestMethod.GET)
    public ModelAndView drink(ModelAndView mav) {
        List<Drink> drinkList = drinkService.getAllDrink();
        mav.addObject("drinkList", drinkList);
        mav.setViewName("drink");
        return mav;
    }

    @RequestMapping(value = "drink", method = RequestMethod.POST)
    public ModelAndView addDrink(ModelAndView mav, @ModelAttribute("drinkForm") @Validated DrinkForm form) {
        drinkService.addDrink(form);
        mav.setViewName("redirect:/");
        return mav;
    }
}
