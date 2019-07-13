package com.dziobsoft.doctormanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.dziobsoft.doctormanager.*")
public class DoctorManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DoctorManagerApplication.class, args);
    }

}
