package com.practice.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author JunyaShirahama
 */
@Entity
@Table(name = "drink")
@Getter
@Setter
public class Drink {

    @Id
    private Integer drinkId;

    private String drinkName;

    private Integer price;
}
