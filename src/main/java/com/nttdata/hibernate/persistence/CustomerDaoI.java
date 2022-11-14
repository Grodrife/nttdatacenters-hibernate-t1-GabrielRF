package com.nttdata.hibernate.persistence;

import java.util.List;

/**
 * Taller práctico Hibernate - Taller 1
 * 
 * DAO de tabla NTTDATA_HT1_CUSTOMER
 * 
 * @author Gabriel Rodriguez Felix
 *
 */
public interface CustomerDaoI extends CommonDaoI<Customer> {

	/**
	 * Consulta por nombre y apellidos
	 * 
	 * @param customerName
	 * @param customerFirstLastName
	 * @param customerSecondLastName
	 * 
	 * @return List<Customer>
	 */
	public List<Customer> searchByNameAndLastNames(final String customerName, final String customerFirstLastName,
			final String customerSecondLastName);
}
