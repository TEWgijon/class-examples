package com.tew.gestioneitor.service.impl.actions;


import com.tew.gestioneitor.infrastructure.Factories;
import com.tew.gestioneitor.model.Alumno;
import com.tew.gestioneitor.repository.AlumnoDao;
import com.tew.gestioneitor.repository.exception.NotPersistedException;
import com.tew.gestioneitor.service.exceptions.EntityNotFoundException;

public class AlumnosUpdate {
    private final AlumnoDao dao = Factories.persistence.createAlumnoDao();

    public void update(Alumno alumno) throws EntityNotFoundException {
        try {
            dao.update(alumno);
        } catch (NotPersistedException ex) {
            throw new EntityNotFoundException("Alumno no eliminado " + alumno, ex);
        }
    }

}
