package com.roycabrera.microservicios.app.examenes.services;

import com.roycabrera.microservicios.commons.examenes.models.entity.Asignatura;
import com.roycabrera.microservicios.commons.examenes.models.entity.Examen;
import com.roycabrera.microservicios.commons.services.CommonService;

import java.util.List;

public interface ExamenService extends CommonService<Examen>{
    public List<Examen> findByNombre(String nombre);
    public Iterable<Asignatura> findAllAsignaturas();
}
