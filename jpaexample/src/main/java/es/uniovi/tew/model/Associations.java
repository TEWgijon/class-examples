package es.uniovi.tew.model;

public class Associations {
    public static class Matricular {
        public static void link(Alumno alumno, Asignatura asignatura, Matricula matricula) {
            matricula.setAlumno(alumno);
            matricula.setAsignatura(asignatura);
            alumno.getMutableMatriculas().add(matricula);
            asignatura.getMutableMatriculas().add(matricula);
        }

        public static void unlink(Matricula matricula) {
            matricula.getAsignatura().getMutableMatriculas().remove(matricula);
            matricula.getAlumno().getMutableMatriculas().remove(matricula);
            matricula.setAsignatura(null);
            matricula.setAlumno(null);
        }
    }

    public static class Evaluar {
        public static void link(Matricula matricula, Convocatoria convocatoria) {
            convocatoria.setMatricula(matricula);
            matricula.getMutableConvocatorias().add(convocatoria);
        }

        public static void unlink(Convocatoria convocatoria) {
            convocatoria.getMatricula().getMutableConvocatorias().remove(convocatoria);
            convocatoria.setMatricula(null);
        }
    }
}
