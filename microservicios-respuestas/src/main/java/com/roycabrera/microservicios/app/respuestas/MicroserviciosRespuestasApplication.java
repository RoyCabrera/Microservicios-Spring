package com.roycabrera.microservicios.app.respuestas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan({"com.roycabrera.microservicios.app.respuestas.models.entity",
        "com.roycabrera.microservicios.commons.alumnos.models.entity",
        "com.roycabrera.microservicios.commons.examenes.models.entity"})
public class MicroserviciosRespuestasApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviciosRespuestasApplication.class, args);
    }

}
