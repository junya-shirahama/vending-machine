package com.practice;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author JunyaShirahama
 */
@Entity
@Table(name = "user")
@Getter
@Setter
public class User {

    @Id
    private String username;

    private String password;
}
