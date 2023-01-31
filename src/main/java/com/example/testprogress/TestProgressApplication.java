package com.example.testprogress;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class TestProgressApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestProgressApplication.class, args);
    }

}
