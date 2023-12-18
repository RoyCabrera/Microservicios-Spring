package com.roycabrera.app.usuarios.services;

import com.roycabrera.microservicios.commons.alumnos.models.entity.Alumno;
import com.roycabrera.app.usuarios.models.repository.AlumnoRepository;
import com.roycabrera.microservicios.commons.services.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class AlumnoServiceImpl extends CommonServiceImpl<Alumno,AlumnoRepository> implements AlumnoService{

    @Override
    @Transactional(readOnly = true)
    public List<Alumno> findByNombreOrApellido(String term) {
        return repository.findByNombreOrApellido(term);
    }
}
