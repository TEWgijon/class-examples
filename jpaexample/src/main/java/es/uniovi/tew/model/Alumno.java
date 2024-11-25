package es.uniovi.tew.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Alumno {
    @OneToMany(mappedBy = "alumno")
    private final Set<Matricula> matriculas = new HashSet<>();
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String dni;
    private String nombre;
    private String apellido;

    protected Alumno() {

    }

    public Alumno(String dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Set<Matricula> getMatriculas() {
        return new HashSet<>(matriculas);
    }

    Set<Matricula> getMutableMatriculas() {
        return matriculas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Alumno alumno = (Alumno) o;

        return dni.equals(alumno.dni);
    }

    @Override
    public int hashCode() {
        return dni.hashCode();
    }

    public float calcularMedia() {
        float acc = 0;
        int count = 0;
        for (Matricula m : matriculas)
            for (Convocatoria c : m.getConvocatorias()) {
                acc += c.getNota();
                count++;
            }
        return acc / count;
    }
}
