package com.roycabrera.microservicios.app.examenes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@EnableEurekaClient
@SpringBootApplication
@EntityScan("com.roycabrera.microservicios.commons.examenes.models.entity")
public class MicroserviciosExamenesApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviciosExamenesApplication.class, args);
    }

}
