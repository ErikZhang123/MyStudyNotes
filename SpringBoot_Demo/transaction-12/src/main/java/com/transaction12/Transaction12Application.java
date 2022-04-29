package com.transaction12;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class Transaction12Application {

    public static void main(String[] args) {
        SpringApplication.run(Transaction12Application.class, args);
    }

}
