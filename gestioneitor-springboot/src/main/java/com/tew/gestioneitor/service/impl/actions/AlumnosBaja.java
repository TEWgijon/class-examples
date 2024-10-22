package com.tew.gestioneitor.service.impl.actions;

import com.tew.gestioneitor.infrastructure.Factories;
import com.tew.gestioneitor.repository.AlumnoDao;
import com.tew.gestioneitor.repository.exception.NotPersistedException;
import com.tew.gestioneitor.service.exceptions.EntityNotFoundException;

public class AlumnosBaja {
    private final AlumnoDao dao = Factories.persistence.createAlumnoDao();

    public void delete(Long id) throws EntityNotFoundException {
        try {
            dao.delete(id);
        } catch (NotPersistedException ex) {
            throw new EntityNotFoundException("Alumno no eliminado " + id, ex);
        }
    }
}
