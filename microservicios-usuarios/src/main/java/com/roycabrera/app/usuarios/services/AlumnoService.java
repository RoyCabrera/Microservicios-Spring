package com.roycabrera.app.usuarios.services;

import com.roycabrera.microservicios.commons.alumnos.models.entity.Alumno;
import com.roycabrera.microservicios.commons.services.CommonService;

import java.util.List;

public interface AlumnoService extends CommonService<Alumno>{

    public List<Alumno> findByNombreOrApellido(String term);
}
