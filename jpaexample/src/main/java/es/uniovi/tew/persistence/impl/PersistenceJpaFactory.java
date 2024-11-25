package es.uniovi.tew.persistence.impl;

import es.uniovi.tew.persistence.AlumnoDao;
import es.uniovi.tew.persistence.PersistenceFactory;

public class PersistenceJpaFactory implements PersistenceFactory {
    @Override
    public AlumnoDao forAlumnoDao() {
        return new AlumnoJpaDao();
    }
}
