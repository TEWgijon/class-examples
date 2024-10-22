package com.tew.gestioneitor.service.impl.actions;

import com.tew.gestioneitor.infrastructure.Factories;
import com.tew.gestioneitor.model.Alumno;
import com.tew.gestioneitor.repository.AlumnoDao;
import com.tew.gestioneitor.service.exceptions.EntityNotFoundException;

public class AlumnosBuscar {
    private final AlumnoDao dao = Factories.persistence.createAlumnoDao();

    public Alumno find(Long id) throws EntityNotFoundException {
        Alumno a = dao.findById(id);
        if (a == null) {
            throw new EntityNotFoundException("No se ha encontrado el alumno");
        }

        return a;
    }

}
