package es.tew.restexample;

import java.util.ArrayList;
import java.util.List;

public class AlumnoServiceImpl implements AlumnoService {
    private final List<Alumno> alumnos = new ArrayList<>() {{
        add(new Alumno("UO123456", "Enol"));
        add(new Alumno("UO654321", "Oscar"));
        add(new Alumno("UO135246", "María"));
        add(new Alumno("UO246135", "Sonia"));
    }};

    @Override
    public Alumno getAlumnoByUO(String uo) {
        for (Alumno a : alumnos)
            if (a.getUo().equals(uo))
                return a;
        return null;
    }

    @Override
    public void addAlumno(Alumno alumno) {
        alumnos.add(alumno);

        System.out.println("Añadiendo alumno: " + alumno);
    }

    @Override
    public void updateAlumno(Alumno alumno) {
        for (Alumno a : alumnos)
            if (a.getUo().equals(alumno.getUo()))
                a.setName(alumno.getName());

        System.out.println("Actualizando alumno: " + alumno);
    }

    @Override
    public void deleteAlumno(String uo) {
        for (Alumno a : alumnos)
            if (a.getUo().equals(uo)) {
                alumnos.remove(a);
                break;
            }

        System.out.println("Eliminando alumno: " + uo);
    }
}
