package com.roycabrera.microservicios.app.cursos.services;

import com.roycabrera.microservicios.app.cursos.models.entity.Curso;
import com.roycabrera.microservicios.commons.services.CommonService;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

public interface CursoService extends CommonService<Curso> {

    public Curso findCursoByAlumnoId(Long id);
    public Iterable<Long> obtenerExamenesIdsConRespuestasAlumno(Long alumnoId);
}
