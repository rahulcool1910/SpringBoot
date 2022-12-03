package com.example.springbasics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication(scanBasePackages={})
public class SpringBasicsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBasicsApplication.class, args);
        System.out.println("Hello world1");
    }
    /*
    * Beans must follow the following conditions
       $ Must be Serializable and capable of implementing Serializable
       $ must have public noo-args constructor
       $ all properties must be private with getter and setters
    * */
    /*
    * Bean is just a class which follows certain constraints
    *  */
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
