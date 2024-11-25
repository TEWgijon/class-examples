package es.uniovi.tew.service.impl.classes;

import es.uniovi.tew.infraestructure.Factory;
import es.uniovi.tew.model.Alumno;
import es.uniovi.tew.service.template.Command;

public class AltaAlumno implements Command<Void> {
    private final Alumno a;

    public AltaAlumno(Alumno a) {
        this.a = a;
    }

    @Override
    public Void execute() {
        Factory.persistence.forAlumnoDao().save(a);

        return null;
    }
}
