package com.tew.gestioneitor.infrastructure;


import com.tew.gestioneitor.repository.PersistenceFactory;
import com.tew.gestioneitor.repository.impl.SimplePersistenceFactory;


/**
 * Esta clase es la que realemente relaciona las interfaces de las capas
 * con sus implementaciones finales. Si se deben hacer cambios de implementaci��n
 * en algunas de las capas habr��a que retocar esta clase.
 * <p>
 * En desarrollos mas sofisticados esto se especificar��n en ficheros de
 * configuraci��n lo que permitiria al "assembler" y "deployer" ajustar los
 * ensamblajes entre capas sin necesidad de recompilar.
 * Assembler: forma la aplicaci��n a base de componentes
 * desarrollados externamente
 * Deployer: Adapta la aplicaci��n, o reconfigura la aplicaci��n en
 * explotaci��n a las m��quinas/contenedores (tiers/layers)
 * <p>
 * Hay frameworks especializados en eso precisamente, por ejemplo Spring.
 *
 * @author Enrique
 */
public class Factories {

    public static PersistenceFactory persistence = new SimplePersistenceFactory();

}
