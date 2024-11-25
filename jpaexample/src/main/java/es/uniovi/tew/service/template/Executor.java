package es.uniovi.tew.service.template;

import es.uniovi.tew.persistence.util.Jpa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class Executor {

    public <T> T execute(Command<T> cmd) {
        EntityManager em = Jpa.createEntityManager();
        try {
            EntityTransaction tx = em.getTransaction();
            try {
                tx.begin();

                T res = cmd.execute();
                tx.commit();

                return res;
            } catch (Exception e) {
                if (tx.isActive())
                    tx.rollback();
                throw e;
            }
        } finally {
            Jpa.closeEm();
        }
    }
}
