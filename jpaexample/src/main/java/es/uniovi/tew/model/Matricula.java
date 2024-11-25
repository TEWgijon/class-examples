package es.uniovi.tew.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"curso", "alumno_id", "asignatura_id"})})
public class Matricula {
    @OneToMany(mappedBy = "matricula")
    private final Set<Convocatoria> convocatorias = new HashSet<>();
    @Id
    @GeneratedValue
    private Long id;

    private String curso;
    @ManyToOne
    private Alumno alumno;
    @ManyToOne
    private Asignatura asignatura;

    protected Matricula() {

    }

    public Matricula(Alumno alumno, Asignatura asignatura, String curso) {
        this.curso = curso;
        Associations.Matricular.link(alumno, asignatura, this);
    }

    public Alumno getAlumno() {
        return alumno;
    }

    void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public String getCurso() {
        return curso;
    }

    public Set<Convocatoria> getConvocatorias() {
        return new HashSet<>(convocatorias);
    }

    Set<Convocatoria> getMutableConvocatorias() {
        return convocatorias;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Matricula matricula = (Matricula) o;

        if (!alumno.equals(matricula.alumno)) return false;
        if (!asignatura.equals(matricula.asignatura)) return false;
        return curso.equals(matricula.curso);
    }

    @Override
    public int hashCode() {
        int result = alumno.hashCode();
        result = 31 * result + asignatura.hashCode();
        result = 31 * result + curso.hashCode();
        return result;
    }
}
