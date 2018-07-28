package com.practice;

import lombok.Getter;
import lombok.Setter;

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
    private String drink;

    @Min(0)
    private Integer yen10;
    @Min(0)
    private Integer yen50;
    @Min(0)
    private Integer yen100;
    @Min(0)
    private Integer yen500;
    @Min(0)
    private Integer yen1000;

    public Integer getSumYen() {
        Integer sum = 0;
        if (this.yen10 != null) {
            sum += 10 * this.yen10;
        }
        if (this.yen50 != null) {
            sum += 50 * this.yen50;
        }
        if (this.yen100 != null) {
            sum += 100 * this.yen100;
        }
        if (this.yen500 != null) {
            sum += 500 * this.yen500;
        }
        if (this.yen1000 != null) {
            sum += 1000 * this.yen1000;
        }
        return sum;
    }
}
