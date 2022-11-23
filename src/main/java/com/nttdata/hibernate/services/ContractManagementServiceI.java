package com.nttdata.hibernate.services;

import java.util.List;

import com.nttdata.hibernate.persistence.Contract;

/**
 * Taller practico Hibernate - Taller 1
 * 
 * Interfaz del servicio de contratos
 * 
 * @author Gabriel Rodriguez Felix
 *
 */
public interface ContractManagementServiceI {

	/**
	 * Metodo para insertar un nuevo Contrato
	 * 
	 * @param contract
	 */
	public void insertNewContract(final Contract contract);

	/**
	 * Metodo para recoger todos los registros de contratos de la BBDD
	 * 
	 * @return List<Contract>
	 */
	public List<Contract> searchAll();

	/**
	 * Metodo para buscar un registro de contrato segun un id
	 * 
	 * @param contractId
	 * @return Contract
	 */
	public Contract searchById(final Integer contractId);

	/**
	 * Metodo para eliminar un Contrato de los registros de la BBDD
	 * 
	 * @param contract
	 */
	public void deleteContract(final Contract contract);

	/**
	 * Metodo para actualizar un Contrato de los registros de la BBDD
	 * 
	 * @param contract
	 */
	public void updateContract(final Contract contract);

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
