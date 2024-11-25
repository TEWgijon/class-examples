package es.uniovi.tew.infraestructure;

import es.uniovi.tew.persistence.PersistenceFactory;
import es.uniovi.tew.persistence.impl.PersistenceJpaFactory;
import es.uniovi.tew.service.ServiceFactory;
import es.uniovi.tew.service.impl.ServiceFactoryImpl;

public class Factory {
    public static final PersistenceFactory persistence = new PersistenceJpaFactory();
    public static final ServiceFactory service = new ServiceFactoryImpl();
}
