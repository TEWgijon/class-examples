package es.uniovi.tew;

import es.uniovi.tew.model.Alumno;
import es.uniovi.tew.model.Convocatoria;
import es.uniovi.tew.model.Matricula;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EjemploJPA");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            final String dniBuscado = "12345678Z";

            Alumno a = em.createQuery("SELECT a FROM Alumno a WHERE a.dni=:dni", Alumno.class).setParameter("dni", dniBuscado).getSingleResult();

            for (Matricula m : a.getMatriculas())
                for (Convocatoria c : m.getConvocatorias())
                    System.out.println(a.getNombre() + " se presentó a " + m.getAsignatura().getNombre() +
                            " en " + c.getPeriodoEvaluacion() + " del curso " + m.getCurso() +
                            " con la calificación de " + c.getNota());




            List<Convocatoria> convocatorias = em.createQuery(
                            "SELECT c from Convocatoria c WHERE c.matricula.alumno.dni=:dni", Convocatoria.class)
                    .setParameter("dni", dniBuscado).getResultList();

            System.out.print("Las notas son: ");
            for (Convocatoria c : convocatorias) {
                System.out.print(c.getNota() + ", ");
            }

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
