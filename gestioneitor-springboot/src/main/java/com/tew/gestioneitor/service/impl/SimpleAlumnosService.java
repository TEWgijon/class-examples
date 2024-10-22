package com.tew.gestioneitor.service.impl;

import com.tew.gestioneitor.model.Alumno;
import com.tew.gestioneitor.service.AlumnosService;
import com.tew.gestioneitor.service.exceptions.EntityAlreadyExistsException;
import com.tew.gestioneitor.service.exceptions.EntityNotFoundException;
import com.tew.gestioneitor.service.impl.actions.*;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Clase de implementación (una de las posibles) del interfaz de la fachada de
 * servicios
 *
 * @author Enrique
 */
@Service
public class SimpleAlumnosService implements AlumnosService {

    @Override
    public List<Alumno> getAlumnos() {
        return new AlumnosListado().getAlumnos();
    }

    @Override
    public void saveAlumno(Alumno alumno) throws EntityAlreadyExistsException {
        new AlumnosAlta().save(alumno);
    }

    @Override
    public void updateAlumno(Alumno alumno) throws EntityNotFoundException {
        new AlumnosUpdate().update(alumno);
    }

    @Override
    public void deleteAlumno(Long id) throws EntityNotFoundException {
        new AlumnosBaja().delete(id);
    }

    @Override
    public Alumno findById(Long id) throws EntityNotFoundException {
        return new AlumnosBuscar().find(id);
    }
}
