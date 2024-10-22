package com.tew.gestioneitor.service;

import com.tew.gestioneitor.model.Alumno;
import com.tew.gestioneitor.service.exceptions.EntityAlreadyExistsException;
import com.tew.gestioneitor.service.exceptions.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Este es el interfaz que ofrecer�� cualquier implementaci��n de la clase fachada.
 * <p>
 * Al separar la implementaci��n de la fachada de su interfaz se permite cambiar
 * las implementaciones reales de la fachada. Esto es muy ��til cuando se necesita
 * a��adir funcionalidad extra como acceso remoto, web services,
 * control de acceso, etc. Al hacerlo de esta forma esos cambios solo
 * afectan a las factorias y no al contenido de las capas. Las factor��as, en
 * un desarrollo profesional, se configuran declarativamente (properties, xml, etc)
 *
 * @author alb
 */
public interface AlumnosService {

    List<Alumno> getAlumnos();

    Alumno findById(Long id) throws EntityNotFoundException;

    void saveAlumno(Alumno alumno) throws EntityAlreadyExistsException;

    void updateAlumno(Alumno alumno) throws EntityNotFoundException;

    void deleteAlumno(Long id) throws EntityNotFoundException;

}