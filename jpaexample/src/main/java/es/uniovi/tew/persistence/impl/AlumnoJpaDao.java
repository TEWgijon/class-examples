package es.uniovi.tew.persistence.impl;

import es.uniovi.tew.model.Alumno;
import es.uniovi.tew.persistence.AlumnoDao;
import es.uniovi.tew.persistence.util.Jpa;

import java.util.Optional;

public class AlumnoJpaDao extends BaseJpaDao<Alumno> implements AlumnoDao {
    @Override
    public Optional<Alumno> findByDni(String dni) {
        return Jpa.getManager().createQuery("SELECT a FROM Alumno a WHERE a.dni=:dni", Alumno.class)
                .setParameter("dni", dni).getResultStream().findFirst();
    }
}
