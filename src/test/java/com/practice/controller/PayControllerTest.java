package com.practice.controller;

import com.practice.entity.MyData;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import static org.junit.Assert.*;

/**
 * Created by JunyaShirahama on 2017/12/18.
 */
public class PayControllerTest {

    @Test
    public void home() throws Exception {
        String expectedResult = "index";
        PayController controller = new PayController();
        ModelAndView mav = new ModelAndView();
        MyData myData = new MyData();
        ModelAndView result = controller.index(mav);
        assertEquals(expectedResult, result);
    }

}