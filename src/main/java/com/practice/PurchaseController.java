package com.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by JunyaShirahama on 2018/01/26.
 */
@Controller
public class PurchaseController {

    @Autowired
    private PurchaseService service;
    @Autowired
    private DrinkRepository drinkRepository;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView index(ModelAndView mav) {
        List<Drink> drinkList = drinkRepository.findAll();
        System.out.println(drinkList.get(0).getDrinkName());
        mav.setViewName("index");
//        mav.setViewName("dummy");
        mav.addObject("message", "いらっしゃいませ！");
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
        int change = service.calculateChange(form.getSumYen());
        StringBuilder builder = new StringBuilder();
        String drink = form.getDrink();
        if (change > 0) {
            mav.addObject("message", "ありがとうございました！");
            builder.append(drink + "と" + change +"円のお釣りです。");
        } else if (change == 0) {
            builder.append(drink + "になります。");
        } else {
            mav.addObject("message", "もう一度トライ！");
            builder.append("お金が" + Math.abs(change) + "円足りません。");
        }
        builder.toString();
        mav.addObject("result", builder);
        return mav;
    }
}
