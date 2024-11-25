package es.uniovi.tew.service.impl.classes;

import es.uniovi.tew.infraestructure.Factory;
import es.uniovi.tew.model.Alumno;
import es.uniovi.tew.service.template.Command;

import java.util.List;

public class GetAllAlumnos implements Command<List<Alumno>> {
    @Override
    public List<Alumno> execute() {
        return Factory.persistence.forAlumnoDao().findAll();
    }
}
