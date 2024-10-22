package es.tew.soapexample;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

@WebService
public interface AlumnoService {
    @WebMethod
    String findAlumno(@WebParam(name="uo") String uo);
}
