package com.practice.repositories;

import java.io.Serializable;
import java.util.List;

/**
 * Created by JunyaShirahama on 2018/01/17.
 */
public interface MyDataDao<T> extends Serializable {

    public List<T> getAll();
    public T findById(long id);
    public List<T> findByName(String name);
    public List<T> find(String fstr);
}
