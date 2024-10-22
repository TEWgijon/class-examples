package es.tew.soapexample;

import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;

import java.util.HashMap;
import java.util.Map;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class AlumnoServiceImpl implements AlumnoService {
    private final Map<String, String> alumnos = new HashMap<>() {{
        put("UO123456", "Enol");
        put("UO654321", "Oscar");
        put("UO135246", "María");
        put("UO246135", "Andrea");
    }};

    @Override
    public String findAlumno(String uo) {
        return alumnos.getOrDefault(uo, "No identificado");
    }
}
