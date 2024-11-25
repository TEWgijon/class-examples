package es.uniovi.tew.persistence;

import es.uniovi.tew.model.Alumno;

import java.util.Optional;

public interface AlumnoDao extends BaseDao<Alumno> {
    Optional<Alumno> findByDni(String dni);
}
