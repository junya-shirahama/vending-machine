package com.practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author JunyaShirahama
 */
@Controller
public class ErrorController {

    @RequestMapping(value = "accessDeniedError", method = RequestMethod.GET)
    public ModelAndView index(ModelAndView mav) {
        mav.setViewName("access_denied_error");
        return mav;
    }
}
