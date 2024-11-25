package es.uniovi.tew;

import es.uniovi.tew.infraestructure.Factory;
import es.uniovi.tew.persistence.util.Jpa;

public class MainArquitectura {
    public static void main(String[] args) {
        String dni = "12345678Z";
        System.out.println("La nota media de " + dni + " es " + Factory.service.forAlumno().calcularNotaMedia(dni));

        Jpa.closeEmf();
    }
}
