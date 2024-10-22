package com.tew.gestioneitor.service.impl.actions;

import com.tew.gestioneitor.infrastructure.Factories;
import com.tew.gestioneitor.model.Alumno;
import com.tew.gestioneitor.repository.AlumnoDao;

import java.util.List;

/**
 * Esta clase pertenece a la capa de persistencia y ejecuta un proceso
 * de negocio.
 * <p>
 * Si el problema a resolver fuese m??????s complejo habr?????? otras muchas clases de
 * este estilo en esta capa.
 * <p>
 * Las clases que forman la capa de negocio pueden necesitar acceder a la capa
 * de persistencia para resolver su cometido. Esta oculta los detalles de la
 * tecnolog??????a de persistencia ofreciendo m??????todos del estilo: crear, borrer,
 * actualizar y diversas consultas.
 */
public class AlumnosListado {
    private final AlumnoDao dao = Factories.persistence.createAlumnoDao();

    public List<Alumno> getAlumnos() {
        // Aqu?????? iria l??????gica de negocio que ejecutase alg??????n proceso ...
        //... en este caso el ejemplo estan sencillo que no hay nada que hacer

        // Acceso a la capa de persistencia a traves de su fachada
        // La fachada se obtiene de la factor??????a
        return dao.getAlumnos();

        // Aqu?????? podr??????a ir m??????s l??????gica de negocio que procesase los datos traidos
        // de persistencia
        // ...
    }
}
