package es.uniovi.tew.service;

import es.uniovi.tew.model.Alumno;

import java.util.List;

public interface AlumnoService {
    void altaAlumno(Alumno a);

    void eliminarAlumno(String dni);

    List<Alumno> getAllAlumnos();

    float calcularNotaMedia(String dni);
}
