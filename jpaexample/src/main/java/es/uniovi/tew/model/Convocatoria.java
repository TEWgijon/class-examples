package es.uniovi.tew.model;

import jakarta.persistence.*;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"periodo_evaluacion", "matricula_id"})})
public class Convocatoria {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "periodo_evaluacion")
    @Enumerated(EnumType.STRING)
    private PeriodoEvaluacion periodoEvaluacion;
    @ManyToOne
    private Matricula matricula;
    private float nota;

    protected Convocatoria() {

    }

    public Convocatoria(Matricula matricula, PeriodoEvaluacion periodoEvaluacion, float nota) {
        this.periodoEvaluacion = periodoEvaluacion;
        this.nota = nota;
        Associations.Evaluar.link(matricula, this);
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public PeriodoEvaluacion getPeriodoEvaluacion() {
        return periodoEvaluacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Convocatoria that = (Convocatoria) o;

        if (!matricula.equals(that.matricula)) return false;
        return periodoEvaluacion == that.periodoEvaluacion;
    }

    @Override
    public int hashCode() {
        int result = matricula.hashCode();
        result = 31 * result + periodoEvaluacion.hashCode();
        return result;
    }
}
