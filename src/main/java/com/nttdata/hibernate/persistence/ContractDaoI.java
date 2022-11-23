package com.nttdata.hibernate.persistence;

import java.util.List;

/**
 * Taller práctico Hibernate - Taller 1
 * 
 * DAO de tabla NTTDATA_HT1_CONTRACT
 * 
 * @author Gabriel Rodriguez Felix
 *
 */
public interface ContractDaoI extends CommonDaoI<Contract> {

	/**
	 * Metodo para consultar aquellos contratos con fecha vigente
	 * 
	 * @return List<Contract>
	 */
	public List<Contract> searchCurrentContracts();

	/**
	 * Metodo para consultar los contratos de los clientes con DNI en concreto
	 * 
	 * @param customerIdentityDocument
	 * @return List<Contract>
	 */
	public List<Contract> searchByCustomerIdentityDocument(String customerIdentityDocument);
}
