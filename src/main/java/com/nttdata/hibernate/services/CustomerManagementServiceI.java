package com.nttdata.hibernate.services;

import java.time.LocalDate;
import java.util.List;

import com.nttdata.hibernate.persistence.Customer;

/**
 * Taller practico Hibernate - Taller 1
 * 
 * Interfaz del servicio de clientes
 * 
 * @author Gabriel Rodriguez Felix
 *
 */
public interface CustomerManagementServiceI {

	/**
	 * Metodo para insertar un nuevo Cliente
	 * 
	 * @param customer
	 */
	public void insertNewCustomer(final Customer customer);

	/**
	 * Metodo para recoger todos los registros de clientes de la BBDD
	 * 
	 * @return List<Customer>
	 */
	public List<Customer> searchAll();

	/**
	 * Metodo para buscar un registro de cliente segun un id
	 * 
	 * @param customerId
	 * @return Customer
	 */
	public Customer searchById(final Integer customerId);

	/**
	 * Metodo para eliminar un Cliente de los registros de la BBDD
	 * 
	 * @param customer
	 */
	public void deleteCustomer(final Customer customer);

	/**
	 * Metodo para actualizar un Cliente de los registros de la BBDD
	 * 
	 * @param customer
	 */
	public void updateCustomer(final Customer customer);

	/**
	 * Metodo para recoger una lista de los registros de clientes que coincidan con
	 * el nombre y los apellidos
	 * 
	 * @param customerName
	 * @param customerFirstLastName
	 * @param customerSecondLastName
	 * @return List<Customer>
	 */
	public List<Customer> searchByNameAndLastNames(String customerName, String customerFirstLastName,
			String customerSecondLastName);

	/**
	 * Metodo para recoger una lista de los registros de clientes a los que tengan
	 * algun contrato que caduque antes de la fecha concretada
	 * 
	 * @param contractEndDate
	 * @return List<Customer>
	 */
	public List<Customer> searchCustomerEndBeforeDate(final LocalDate contractEndDate);
}
