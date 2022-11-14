package com.nttdata.hibernate.persistence;

import java.util.List;

import org.hibernate.Session;

/**
 * Taller practico Hibernate - Taller 1
 * 
 * DAO de tabla NTTDATA_HT1_CUSTOMER
 * 
 * @author Gabriel Rodriguez Felix
 *
 */
public class CustomerDaoImpl extends CommonDaoImpl<Customer> implements CustomerDaoI {

	// Sesion
	private Session session;

	/**
	 * Metodo constructor
	 * 
	 * @param session
	 */
	public CustomerDaoImpl(Session session) {
		super(session);
		this.session = session;
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public List<Customer> searchByNameAndLastNames(String name, String firstLastName, String secondLastName) {

		// Comprobacion sesion abierta
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Devolucion de Clientes que coincida con el nombre y apellidos
		return session.createQuery("FROM Customer WHERE customerName='" + name + "' AND customerFirstLastName='"
				+ firstLastName + "' AND customerSecondLastName='" + secondLastName + "'").list();

	}

}
