package com.tew.gestioneitor.repository.impl;


import com.tew.gestioneitor.repository.AlumnoDao;
import com.tew.gestioneitor.repository.PersistenceFactory;

/**
 * Implementaci??????n de la factoria que devuelve implementaci??????n de la capa
 * de persistencia con Jdbc
 *
 * @author Enrique
 */
public class SimplePersistenceFactory implements PersistenceFactory {

    @Override
    public AlumnoDao createAlumnoDao() {
        return new AlumnoJdbcDao();
    }

}
