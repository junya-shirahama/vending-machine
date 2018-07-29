package com.practice.form;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.validation.constraints.Min;

/**
 * @author JunyaShirahama
 */
@Getter
@Setter
public class DrinkForm {

    @NonNull
    private String drinkName;

    @Min(0)
    private Integer price;
}
