package es.uniovi.tew.persistence.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Jpa {

    private static EntityManager em;
    private static EntityManagerFactory emf = null;

    public static EntityManager createEntityManager() {
        EntityManager entityManager = getEmf().createEntityManager();
        em = entityManager;
        return entityManager;
    }

    public static EntityManager getManager() {
        return em;
    }

    public static void closeEm() {
        if (em == null) return;
        if (em.isOpen())
            em.close();
        em = null;
    }

    public static void closeEmf() {
        if (emf == null) return;
        if (emf.isOpen())
            emf.close();
        emf = null;
    }

    private static EntityManagerFactory getEmf() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("EjemploJPA");
        }
        return emf;
    }

}
