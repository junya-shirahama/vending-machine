package com.practice.controller;

import com.practice.DrinkBean;
import com.practice.entity.Drink;
import com.practice.form.PurchaseForm;
import com.practice.service.DrinkService;
import com.practice.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by JunyaShirahama on 2018/01/26.
 */
@Controller
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;
    @Autowired
    private DrinkService drinkService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView index(ModelAndView mav) {
        mav.addObject("message", "いらっしゃいませ！");
        DrinkBean drinkBean = purchaseService.getPurchasableDrinkList();
        mav.addObject("drinkList", drinkBean.getDrinkList());
        mav.setViewName("index");
        return mav;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ModelAndView purchase(@ModelAttribute("purchaseForm") @Validated PurchaseForm form,
                                 BindingResult result,
                                 ModelAndView mav) {
        if (result.hasErrors()) {
            mav.setViewName("redirect:/");
            return mav;
        }
        mav.setViewName("purchase");
        Integer drinkId = Integer.valueOf(form.getDrink());
        int change = purchaseService.calculateChange(drinkId.intValue(), form.getSumYen());
        Drink drink = drinkService.getDrinkById(drinkId);
        StringBuilder builder = new StringBuilder();
        if (change > 0) {
            mav.addObject("message", "ありがとうございました！");
            builder.append(drink.getDrinkName() + "と" + change +"円のお釣りです。");
        } else if (change == 0) {
            builder.append(drink.getDrinkName() + "になります。");
        } else {
            mav.addObject("message", "もう一度トライ！");
            builder.append("お金が" + Math.abs(change) + "円足りません。");
        }
        builder.toString();
        mav.addObject("result", builder);
        return mav;
    }
}
