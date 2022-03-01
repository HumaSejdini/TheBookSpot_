package com.example.baza;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

@ServletComponentScan
@SpringBootApplication
public class BazaApplication {

    public static void main(String[] args) {
        SpringApplication.run(BazaApplication.class, args);
    }

}
