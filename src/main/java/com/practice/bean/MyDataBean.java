package com.practice.bean;

import com.practice.entity.MyData;
import com.practice.repositories.MyDataRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by JunyaShirahama on 2018/01/20.
 */
public class MyDataBean {

    @Autowired
    MyDataRepository repository;

    public String getTableTagById(Long id) {
        MyData data = repository.findOne(id);
        String result = "<tr><td>" + data.getName() + "</td><td>" + data.getMail() + "</td><td>" + data.getAge() +
                "</td><td>" + data.getMemo() + "</td></tr>";
        return result;
    }
}
