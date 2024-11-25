package es.uniovi.tew.service.impl.classes;

import es.uniovi.tew.infraestructure.Factory;
import es.uniovi.tew.model.Alumno;
import es.uniovi.tew.service.template.Command;

import java.util.Optional;

public class CalcularNotaMedia implements Command<Float> {
    private final String dni;

    public CalcularNotaMedia(String dni) {
        this.dni = dni;
    }

    @Override
    public Float execute() {
        Optional<Alumno> alumno = Factory.persistence.forAlumnoDao().findByDni(dni);
        return alumno.map(Alumno::calcularMedia).orElse(-1F);
    }
}
