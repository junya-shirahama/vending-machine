package com.practice;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by JunyaShirahama on 2018/01/30.
 */
@Getter
@Setter
public class PurchaseForm implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    @Min(1)
    @Max(10000)
    private Integer money;

    @NotNull
    private String drink;
}
