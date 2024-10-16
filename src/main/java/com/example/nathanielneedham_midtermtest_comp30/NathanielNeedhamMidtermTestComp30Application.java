package com.example.nathanielneedham_midtermtest_comp30;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.example.nathanielneedham_midtermtest_comp30")
public class NathanielNeedhamMidtermTestComp30Application implements CommandLineRunner {

    @Autowired
    private SensorRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(NathanielNeedhamMidtermTestComp30Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Iterable<Sensor> iterator = repository.findAll();
        System.out.println("All the Sensors: ");
        iterator.forEach(item -> System.out.println(item));
    }
}
