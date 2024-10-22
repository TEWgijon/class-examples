package es.uniovi.tew.graphqlejemplo;

import java.util.ArrayList;
import java.util.List;

public class Alumno {
    private final static List<Alumno> alumnos = new ArrayList<>() {{
        add(new Alumno("UO123456", "Enol"));
        add(new Alumno("UO654321", "Oscar"));
        add(new Alumno("UO135246", "María"));
        add(new Alumno("UO246135", "Sonia"));
    }};

    public static Alumno getByUo(String uo) {
        for (Alumno a : alumnos)
            if (a.getUo().equals(uo))
                return a;
        return null;
    }

    private String uo;
    private String name;

    public Alumno(String uo, String name) {
        this.uo = uo;
        this.name = name;
    }

    public String getUo() {
        return uo;
    }

    public void setUo(String uo) {
        this.uo = uo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
