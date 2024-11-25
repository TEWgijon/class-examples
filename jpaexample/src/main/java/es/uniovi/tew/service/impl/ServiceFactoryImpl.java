package es.uniovi.tew.service.impl;

import es.uniovi.tew.service.AlumnoService;
import es.uniovi.tew.service.ServiceFactory;

public class ServiceFactoryImpl implements ServiceFactory {
    @Override
    public AlumnoService forAlumno() {
        return new AlumnoServiceImpl();
    }
}
