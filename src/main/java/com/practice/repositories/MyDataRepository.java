package com.practice.repositories;

import com.practice.entity.MyData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by JunyaShirahama on 2018/01/14.
 */
@Repository
public interface MyDataRepository extends JpaRepository<MyData, Long> {

    public MyData findById(Long id);
    public List<MyData> findByName(String name);
    public List<MyData> findByIdIsNotNullOrderByIdDesc();
    public List<MyData> findByAgeGreaterThan(Integer age);
    public List<MyData> findByAgeBetween(Integer age1, Integer age2);
}
