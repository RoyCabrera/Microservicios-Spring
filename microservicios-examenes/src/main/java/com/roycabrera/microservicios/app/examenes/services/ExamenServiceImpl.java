package com.roycabrera.microservicios.app.examenes.services;

import com.roycabrera.microservicios.app.examenes.models.repository.AsignaturaRepository;
import com.roycabrera.microservicios.commons.examenes.models.entity.Asignatura;
import com.roycabrera.microservicios.commons.examenes.models.entity.Examen;
import com.roycabrera.microservicios.app.examenes.models.repository.ExamenRepository;
import com.roycabrera.microservicios.commons.services.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ExamenServiceImpl extends CommonServiceImpl<Examen, ExamenRepository> implements ExamenService{

    @Autowired
    private AsignaturaRepository asignaturaRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Examen> findByNombre(String nombre) {
        return repository.findByNombre(nombre);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Asignatura> findAllAsignaturas() {
        return asignaturaRepository.findAll();
    }
}
