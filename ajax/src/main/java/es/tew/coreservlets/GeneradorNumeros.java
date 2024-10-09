package es.tew.coreservlets;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

@Named("generadorNumeros")
@SessionScoped
public class GeneradorNumeros implements java.io.Serializable {
	private double numero = Math.random();

	public double getNumero() {
		return numero;
	}

	public String generar() {
		numero = Math.random();
		return String.format("%f", numero);
	}
}
