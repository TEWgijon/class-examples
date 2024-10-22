package es.uniovi.tew.graphqlejemplo;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class AlumnoController {
    @QueryMapping
    public Alumno alumnoByUo(@Argument String uo) {
        return Alumno.getByUo(uo);
    }
}
