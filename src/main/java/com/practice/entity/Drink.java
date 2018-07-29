package com.practice.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author JunyaShirahama
 */
@Entity
@Table(name = "drink")
@Getter
@Setter
public class Drink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer drinkId;

    private String drinkName;

    private Integer price;
}
