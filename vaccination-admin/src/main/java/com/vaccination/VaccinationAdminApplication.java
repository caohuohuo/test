package com.vaccination;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.vaccination")
public class VaccinationAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(VaccinationAdminApplication.class, args);
    }

}
