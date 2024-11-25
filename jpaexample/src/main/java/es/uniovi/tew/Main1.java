package es.uniovi.tew;

import es.uniovi.tew.model.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Main1 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EjemploJPA");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            /* INICIO DEL CONTEXTO DE PERSISTENCIA */

            Alumno alumno = new Alumno("12345678Z", "Enol", "Garcia");
            em.persist(alumno);

            Asignatura asignatura = new Asignatura("TEW");
            em.persist(asignatura);

            Matricula matricula1 = new Matricula(alumno, asignatura, "2022-2023");
            em.persist(matricula1);

            Convocatoria convocatoria1 = new Convocatoria(matricula1, PeriodoEvaluacion.ENERO, 3);
            em.persist(convocatoria1);

            Matricula matricula2 = new Matricula(alumno, asignatura, "2023-2024");
            em.persist(matricula2);

            Convocatoria convocatoria2 = new Convocatoria(matricula2, PeriodoEvaluacion.ENERO, 4);
            em.persist(convocatoria2);

            Convocatoria convocatoria3 = new Convocatoria(matricula2, PeriodoEvaluacion.MAYO, 5);
            em.persist(convocatoria3);


            /* FIN DEL CONTEXTO DE PERSISTENCIA */

            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }
}
