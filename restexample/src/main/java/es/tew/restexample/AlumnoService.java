package es.tew
.restexample;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/alumno")
public interface AlumnoService {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{uo}")
    Alumno getAlumnoByUO(@PathParam("uo") String uo);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    void addAlumno(Alumno alumno);

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    void updateAlumno(Alumno alumno);

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{uo}")
    void deleteAlumno(@PathParam("uo") String uo);
}
