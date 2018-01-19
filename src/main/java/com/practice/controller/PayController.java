package com.practice.controller;

import com.practice.entity.MyData;
import com.practice.repositories.MyDataDaoImpl;
import com.practice.repositories.MyDataRepository;
import com.practice.service.MyDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JunyaShirahama on 2017/12/18.
 */
@Controller
@RequestMapping
public class PayController {

    @Autowired
    MyDataRepository repository;

    @Autowired
    private MyDataService service;

    @PostConstruct
    public void init() {
        MyData d1 = new MyData();
        d1.setName("tuyano");
        d1.setAge(123);
        d1.setMail("syoda@tuyano.com");
        d1.setMemo("090999999");
        repository.saveAndFlush(d1);
        MyData d2 = new MyData();
        d2.setName("hanako");
        d2.setAge(15);
        d2.setMail("hanako@flower");
        d2.setMemo("080888888");
        repository.saveAndFlush(d2);
        MyData d3 = new MyData();
        d3.setName("sachiko");
        d3.setAge(37);
        d3.setMail("sachiko@happy");
        d3.setMemo("070777777");
        repository.saveAndFlush(d3);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index(ModelAndView mav) {
        mav.setViewName("index");
        mav.addObject("msg", "MyDataのサンプルです。");
        List<MyData> list = service.getAll();
//        mav.addObject("formModel", myData);
        mav.addObject("datalist", list);
        return mav;
    }

//    @RequestMapping(value = "/", method = RequestMethod.POST)
//    @Transactional(readOnly = false)
//    public ModelAndView form(
//            @ModelAttribute("formModel") @Validated MyData myData,
//            BindingResult result,
//            ModelAndView mov) {
//        ModelAndView res = null;
//        if (!result.hasErrors()) {
//            repository.saveAndFlush(myData);
//            res = new ModelAndView("redirect:/");
//        } else {
//            mov.setViewName("index");
//            mov.addObject("msg", "sorry, error is occured...");
//            List<MyData> list = repository.findAll();
//            mov.addObject("datalist", list);
//            res = mov;
//        }
//        return res;
//    }

//    @RequestMapping(value = "/{tax}", method = RequestMethod.GET)
//    public ModelAndView index(@PathVariable int tax, ModelAndView mav) {
//        mav.setViewName("index");
//        mav.addObject("tax", tax);
//        return mav;
//    }

//    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
//    public ModelAndView edit(@ModelAttribute MyData myData, @PathVariable int id, ModelAndView mav) {
//        mav.setViewName("edit");
//        mav.addObject("title", "edit mydata.");
//        MyData data = repository.findById((long) id);
//        mav.addObject("formModel", data);
//        return mav;
//    }

//    @RequestMapping(value = "/edit", method = RequestMethod.POST)
//    @Transactional(readOnly = false)
//    public ModelAndView update(@ModelAttribute MyData myData, ModelAndView mav) {
//        repository.saveAndFlush(myData);
//        return new ModelAndView("redirect:/");
//    }

//    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
//    public ModelAndView delete(@PathVariable int id, ModelAndView mav) {
//        mav.setViewName("delete");
//        mav.addObject("title", "delete mydata.");
//        MyData data = repository.findById((long) id);
//        mav.addObject("formModel", data);
//        return mav;
//    }

//    @RequestMapping(value = "/delete", method = RequestMethod.POST)
//    @Transactional(readOnly = false)
//    public ModelAndView remove(@RequestParam long id, ModelAndView mav) {
//        repository.delete(id);
//        return new ModelAndView("redirect:/");
//    }

    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public ModelAndView find(ModelAndView mav) {
        mav.setViewName("find");
        mav.addObject("title", "Find Page");
        mav.addObject("msg", "MyDataのサンプルです。");
        mav.addObject("value", "");
        List<MyData> list = service.getAll();
        mav.addObject("datalist", list);
        return mav;
    }

    @RequestMapping(value = "/find", method = RequestMethod.POST)
    public ModelAndView search(HttpServletRequest request, ModelAndView mav) {
        mav.setViewName("find");
        String param = request.getParameter("fstr");
        if (param == "") {
            mav = new ModelAndView("redirect:/find");
        } else {
            mav.addObject("title", "Find result");
            mav.addObject("msg", "「" + param + "」の検索結果");
            mav.addObject("value", param);
            List<MyData> list = service.find(param);
            mav.addObject("datalist", list);
        }
        return mav;
    }
}

//class DataObject {
//    private int id;
//    private String name;
//    private String value;
//
//    public DataObject(int id, String name, String value) {
//        super();
//        this.id = id;
//        this.name = name;
//        this.value = value;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getValue() {
//        return value;
//    }
//
//    public void setValue(String value) {
//        this.value = value;
//    }
//}
