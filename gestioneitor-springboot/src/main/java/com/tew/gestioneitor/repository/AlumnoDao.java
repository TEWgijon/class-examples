package com.tew.gestioneitor.repository;

import com.tew.gestioneitor.model.Alumno;
import com.tew.gestioneitor.repository.exception.AlreadyPersistedException;
import com.tew.gestioneitor.repository.exception.NotPersistedException;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Interfaz de la fachada a servicios de persistencia para la entidad Alumno.
 * <p>
 * En esta versi��n aparecen los otros m��todos b��sicos de un servicio
 * de persistencia
 *
 * @author alb
 */
@Repository
public interface AlumnoDao {

    List<Alumno> getAlumnos();

    void save(Alumno a) throws AlreadyPersistedException;

    void update(Alumno a) throws NotPersistedException;

    void delete(Long id) throws NotPersistedException;

    Alumno findById(Long id);

}