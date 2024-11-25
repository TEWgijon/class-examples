package es.uniovi.tew.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Asignatura {
    @OneToMany(mappedBy = "asignatura")
    private final Set<Matricula> matriculas = new HashSet<>();
    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String nombre;

    protected Asignatura() {

    }

    public Asignatura(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
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

        Asignatura that = (Asignatura) o;

        return nombre.equals(that.nombre);
    }

    @Override
    public int hashCode() {
        return nombre.hashCode();
    }
}
