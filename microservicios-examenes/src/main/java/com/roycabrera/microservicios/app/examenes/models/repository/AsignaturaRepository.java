package com.roycabrera.microservicios.app.examenes.models.repository;

import com.roycabrera.microservicios.commons.examenes.models.entity.Asignatura;
import org.springframework.data.repository.CrudRepository;

public interface AsignaturaRepository extends CrudRepository<Asignatura,Long> {
}
