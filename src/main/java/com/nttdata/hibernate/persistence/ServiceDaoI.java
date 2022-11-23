package com.nttdata.hibernate.persistence;

import java.util.List;

/**
 * Taller práctico Hibernate - Taller 1
 * 
 * DAO de tabla NTTDATA_HT1_SERVICE
 * 
 * @author Gabriel Rodriguez Felix
 *
 */
public interface ServiceDaoI extends CommonDaoI<Service> {

	/**
	 * Metodo para obtener los servicios contratados por un cliente
	 * 
	 * @param customerIdentityDocument
	 * @return
	 */
	public List<Service> searchByContractId(Integer contractId);
}
