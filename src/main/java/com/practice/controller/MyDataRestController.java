package com.practice.controller;

import com.practice.entity.MyData;
import com.practice.service.MyDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by JunyaShirahama on 2018/01/19.
 */
@RestController
public class MyDataRestController {

    @Autowired
    private MyDataService service;

    @RequestMapping(value = "rest")
    public List<MyData> restAll() {
        return service.getAll();
    }

    @RequestMapping(value = "/rest/{num}")
    public MyData restBy(@PathVariable int num) {
        return service.get(num);
    }
}
