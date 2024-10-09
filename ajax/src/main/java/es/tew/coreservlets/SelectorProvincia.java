package es.tew.coreservlets;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.model.SelectItem;
import jakarta.inject.Named;



/**
 * From <a href="http://courses.coreservlets.com/Course-Materials/">the
 * coreservlets.com tutorials on servlets, JSP, Struts, JSF, Ajax, GWT, Spring,
 * Hibernate/JPA, and Java programming</a>.
 */

@Named("selectorProvincia")
@SessionScoped
public class SelectorProvincia implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final Map<String, String[]> ciudades = new HashMap<String, String[]>() {{
		put("Asturias", new String[] {"Oviedo", "Avil�s", "Gij�n", "Langreo"});
		put("Cantabria", new String[] {"Santander", "Torrelavega", "Reinosa", "Comillas"});
		put("A Coru�a", new String[] {"Arteixo", "Ferrol", "Ortigueira", "Santiago de Compostela"});
		put("Badajoz", new String[] {"Badajoz", "M�rida", "Talavera la Real", "Zafra"});
	}};

	private String provincia, ciudad;
	private boolean ciudadesEnabled = true;

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
		ciudadesEnabled = false;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public boolean isCiudadesEnabled() {
		return ciudadesEnabled;
	}

	public List<SelectItem> getProvincias() {
		List<SelectItem> items = new ArrayList<SelectItem>();
		items.add(new SelectItem("--- Escoge provincia ---"));
		
		for (String p : ciudades.keySet())
			items.add(new SelectItem(p));
		return items;
	}
	
	public List<SelectItem> getAllCiudades() {
		List<SelectItem> items = new ArrayList<SelectItem>();
		items.add(new SelectItem("--- Escoge provincia ---"));
		
		for (String p : ciudades.keySet()) {
			for (String c : ciudades.get(p)) {
				items.add(new SelectItem(c));
			}
		}
		
		return items;
	}

	public List<SelectItem> getCiudades() {
		List<SelectItem> items = new ArrayList<SelectItem>();

		if (provincia != null && provincia.equals("--- Escoge provincia ---"))
			ciudadesEnabled = true;
		
		if (!ciudadesEnabled && (provincia != null)) {
			 for (String c : ciudades.get(provincia))
				 items.add(new SelectItem(c));
		}
		
		if (items.isEmpty())
			items.add(new SelectItem("--- Escoge ciudad ---"));
		return items;
	}
}
