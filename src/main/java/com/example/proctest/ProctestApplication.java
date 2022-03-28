package com.example.proctest;

import com.example.proctest.application.JavaFXapp;
import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProctestApplication {

    public static void main(String[] args) {
        Application.launch(JavaFXapp.class, args);
    }

}
