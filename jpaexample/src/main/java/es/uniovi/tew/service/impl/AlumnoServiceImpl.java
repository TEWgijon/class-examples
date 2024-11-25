package es.uniovi.tew.service.impl;

import es.uniovi.tew.model.Alumno;
import es.uniovi.tew.service.AlumnoService;
import es.uniovi.tew.service.impl.classes.AltaAlumno;
import es.uniovi.tew.service.impl.classes.CalcularNotaMedia;
import es.uniovi.tew.service.impl.classes.EliminarAlumno;
import es.uniovi.tew.service.impl.classes.GetAllAlumnos;
import es.uniovi.tew.service.template.Executor;

import java.util.List;

public class AlumnoServiceImpl implements AlumnoService {
    private final Executor executor = new Executor();

    @Override
    public void altaAlumno(Alumno a) {
        executor.execute(new AltaAlumno(a));
    }

    @Override
    public void eliminarAlumno(String dni) {
        executor.execute(new EliminarAlumno(dni));
    }

    @Override
    public List<Alumno> getAllAlumnos() {
        return executor.execute(new GetAllAlumnos());
    }

    @Override
    public float calcularNotaMedia(String dni) {
        return executor.execute(new CalcularNotaMedia(dni));
    }
}
