package es.uniovi.tew;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainInicial {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EjemploJPA");
    }
}
