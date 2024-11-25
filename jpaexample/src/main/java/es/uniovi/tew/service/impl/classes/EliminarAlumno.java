package es.uniovi.tew.service.impl.classes;

import es.uniovi.tew.infraestructure.Factory;
import es.uniovi.tew.model.Alumno;
import es.uniovi.tew.persistence.AlumnoDao;
import es.uniovi.tew.service.template.Command;

import java.util.Optional;

public class EliminarAlumno implements Command<Void> {
    private final String dni;

    public EliminarAlumno(String dni) {
        this.dni = dni;
    }

    @Override
    public Void execute() {
        AlumnoDao dao = Factory.persistence.forAlumnoDao();
        Optional<Alumno> alumno = dao.findByDni(dni);
        alumno.ifPresent(dao::remove);

        return null;
    }
}
