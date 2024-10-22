package com.tew.gestioneitor.service.impl.actions;


import com.tew.gestioneitor.infrastructure.Factories;
import com.tew.gestioneitor.model.Alumno;
import com.tew.gestioneitor.repository.AlumnoDao;
import com.tew.gestioneitor.repository.exception.AlreadyPersistedException;
import com.tew.gestioneitor.service.exceptions.EntityAlreadyExistsException;

public class AlumnosAlta {
    private final AlumnoDao dao = Factories.persistence.createAlumnoDao();

    public void save(Alumno alumno) throws EntityAlreadyExistsException {
        try {
            dao.save(alumno);
        } catch (AlreadyPersistedException ex) {
            throw new EntityAlreadyExistsException("Alumno ya existe " + alumno, ex);
        }
    }

}
