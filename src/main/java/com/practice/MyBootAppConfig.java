package com.practice;

import com.practice.bean.MyDataBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by JunyaShirahama on 2018/01/20.
 */
@Configuration
public class MyBootAppConfig {

    @Bean
    MyDataBean myDataBean() {
        return new MyDataBean();
    }
}
