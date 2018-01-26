package com.practice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by JunyaShirahama on 2018/01/26.
 */
@Controller
public class PayController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView index(ModelAndView mav) {
        mav.setViewName("index");
        mav.addObject("message", "いらっしゃいませ！");
        mav.addObject("aaa", "aaa");
        return mav;
    }


}
