package es.tew.coreservlets;

import java.util.ArrayList;
import java.util.List;


import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
@Named("buscadorUsuarios")
@SessionScoped
public class BuscadorUsuarios implements java.io.Serializable {
	private String usuario;
	private String[] todosUsuarios = new String[] { "Pedro", "Juan", "Alvaro", "Almudena", "Maria", "Mario", "Oscar" };
	private List<String> usuarios = new ArrayList<String>();

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
		actualizarListaUsuarios();
	}

	public List<String> getUsuarios() {
		return usuarios;
	}
	
	public String actualizarListaUsuarios() {
		usuarios.clear();
		for (String u : todosUsuarios)
			if (u.contains(usuario))
				usuarios.add(u);
		return usuarios.toString();
	}

}
