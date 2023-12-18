package com.roycabrera.microservicios.app.cursos.controllers;

import com.roycabrera.microservicios.app.cursos.models.entity.Curso;
import com.roycabrera.microservicios.app.cursos.services.CursoService;
import com.roycabrera.microservicios.commons.alumnos.models.entity.Alumno;
import com.roycabrera.microservicios.commons.examenes.models.entity.Examen;
import com.roycabrera.microservicios.commons.services.controllers.CommonController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class CursoController extends CommonController<Curso, CursoService> {

    // EDITAR
    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@Valid @RequestBody Curso curso, BindingResult result, @PathVariable Long id){


        if (result.hasErrors()){
            return this.validar(result);
        }
        Optional<Curso> o = this.service.findById(id);
        if (o.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        Curso dbCurso = o.get();
        dbCurso.setNombre(curso.getNombre());
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(dbCurso));
    }

    // ASIGNAR ALUMNOS
    @PutMapping("/{id}/asignar-alumnos")
    public ResponseEntity<?> asignarAlumno(@RequestBody List<Alumno> alumnos,@PathVariable Long id){

        Optional<Curso> o = this.service.findById(id);
        if (o.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        Curso dbCurso = o.get();
        alumnos.forEach(dbCurso::addAlumno);

        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(dbCurso));
    }

    // ELIMINAR ALUMNO
    @PutMapping("/{id}/eliminar-alumno")
    public ResponseEntity<?> eliminarAlumno(@RequestBody Alumno alumno,@PathVariable Long id){

        Optional<Curso> o = this.service.findById(id);
        if (o.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        Curso dbCurso = o.get();
        dbCurso.removeAlumno(alumno);

        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(dbCurso));
    }

    // BUSCAR CURSO POR ID DE ALUMNO
    @GetMapping("/alumno/{id}")
    public ResponseEntity<?> buscarPorAlumnoId(@PathVariable Long id) {
        Curso curso = service.findCursoByAlumnoId(id);
        if(curso != null){
          List<Long> examenesIds = (List<Long>) service.obtenerExamenesIdsConRespuestasAlumno(id);
          List<Examen> examenes = curso.getExamenes().stream().map(examen -> {
              if (examenesIds.contains(examen.getId())){
                  examen.setRespondido(true);
              }
              return examen;
          }).collect(Collectors.toList());
          curso.setExamenes(examenes);
        }
        return ResponseEntity.ok(curso);
    }

    // ASIGNAR EXAMEN
    @PutMapping("/{id}/asignar-examenes")
    public ResponseEntity<?> asignarExamenes(@RequestBody List<Examen> examenes, @PathVariable Long id){

        Optional<Curso> o = this.service.findById(id);
        if (o.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        Curso dbCurso = o.get();
        examenes.forEach(dbCurso::addExamen);

        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(dbCurso));
    }

    // ELIMINAR ALUMNO
    @PutMapping("/{id}/eliminar-examen")
    public ResponseEntity<?> eliminarExamen(@RequestBody Examen examen,@PathVariable Long id){

        Optional<Curso> o = this.service.findById(id);
        if (o.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        Curso dbCurso = o.get();
        dbCurso.removeExamen(examen);

        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(dbCurso));
    }


}
