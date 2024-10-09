package es.tew.coreservlets;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;


@Named("buscadorUO")
@SessionScoped
public class BuscadorUO implements java.io.Serializable {
	private String uo = "";
	private String nombre = "";

	public String getUo() {
		return uo;
	}

	public void setUo(String uo) {
		this.uo = uo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String buscar() {
		uo = uo.toUpperCase();
		if (uo.equals("UO123456")) {
			nombre = "Juan";
		} else if (uo.equals("UO654321")) {
			nombre = "Maria";
		} else if (uo.equals("UO135246")) {
			nombre = "Andres";
		} else {
			nombre = "Desconocido";
		}
		return nombre;
	}

}
