package com.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by JunyaShirahama on 2018/01/26.
 */
@Controller
public class PayController {

    @Autowired
    private PayService service;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView index(ModelAndView mav) {
        mav.setViewName("index");
        mav.addObject("message", "いらっしゃいませ！");
        return mav;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ModelAndView purchase(@RequestParam("drink")String drink,
                                 @RequestParam("money")int money,
                                 ModelAndView mav) {
        mav.setViewName("purchase");
        mav.addObject("message", "ありがとうございました！");
        int change = service.calculateChange(money);
        StringBuilder builder = new StringBuilder();
        if (change > 0) {
            builder.append(drink + "と" + change +"円のお釣りです。");
        } else if (change == 0) {
            builder.append(drink + "になります。");
        } else {
            builder.append("お金が" + Math.abs(change) + "円足りません。");
        }
        builder.toString();
        mav.addObject("result", builder);
        return mav;
    }
}
