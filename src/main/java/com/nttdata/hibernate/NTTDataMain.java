package com.nttdata.hibernate;

import java.util.Date;

import java.util.List;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nttdata.hibernate.persistence.Customer;
import com.nttdata.hibernate.services.CustomerManagementServiceI;
import com.nttdata.hibernate.services.CustomerManagementServiceImpl;

/**
 * Taller practico Hibernate - Taller 1
 * 
 * Clase main
 * 
 * @author Gabriel Rodriguez Felix
 *
 */
public class NTTDataMain {

	// Logger
	private static final Logger LOG = LoggerFactory.getLogger(NTTDataMain.class);

	/**
	 * Metodo principal
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// Creacion de StringBuilder de apoyo
		// Creacion de la sesion
		final Session session = NTTDataHibernateUtil.getSessionFactory().openSession();
		// Creacion del servicio para Cliente
		final CustomerManagementServiceI customerService = new CustomerManagementServiceImpl(session);

		// Datos de auditoria
		final String updatedUser = "NTTDATA_GRF";
		final Date updatedDate = new Date();

		// Generacion de clientes
		final String name = "Gabriel";
		final String firstLastName = "Rodriguez";
		final String secondLastName = "Felix";
		// Primer cliente - Inicio
		final Customer firstCustomer = new Customer();
		firstCustomer.setCustomerName(name);
		firstCustomer.setCustomerFirstLastName(firstLastName);
		firstCustomer.setCustomerSecondLastName(secondLastName);
		firstCustomer.setCustomerIdentityDocument("11111111A");
		firstCustomer.setUpdatedUser(updatedUser);
		firstCustomer.setUpdatedDate(updatedDate);
		// Primer cliente - Fin
		// Segundo cliente - Inicio
		final Customer secondCustomer = new Customer();
		secondCustomer.setCustomerName("Paco");
		secondCustomer.setCustomerFirstLastName("Perez");
		secondCustomer.setCustomerSecondLastName("Perez");
		secondCustomer.setCustomerIdentityDocument("22222222B");
		secondCustomer.setUpdatedUser(updatedUser);
		secondCustomer.setUpdatedDate(updatedDate);
		// Segundo cliente - Fin
		// Tercer cliente - Inicio
		final Customer thirdCustomer = new Customer();
		thirdCustomer.setCustomerName("Pepe");
		thirdCustomer.setCustomerFirstLastName("Gutierrez");
		thirdCustomer.setCustomerSecondLastName("Gutierrez");
		thirdCustomer.setCustomerIdentityDocument("33333333C");
		thirdCustomer.setUpdatedUser(updatedUser);
		thirdCustomer.setUpdatedDate(updatedDate);
		// Tercer cliente - Fin
		// Cuarto cliente - Inicio
		final Customer fourthCustomer = new Customer();
		fourthCustomer.setCustomerName("Gabriel");
		fourthCustomer.setCustomerFirstLastName("Rodriguez");
		fourthCustomer.setCustomerSecondLastName("Felix");
		fourthCustomer.setCustomerIdentityDocument("44444444D");
		fourthCustomer.setUpdatedUser(updatedUser);
		fourthCustomer.setUpdatedDate(updatedDate);
		// Cuarto cliente - Fin
		// Insercion clientes
		customerService.insertNewCustomer(firstCustomer);
		customerService.insertNewCustomer(secondCustomer);
		customerService.insertNewCustomer(thirdCustomer);
		customerService.insertNewCustomer(fourthCustomer);

		// Consultas
		List<Customer> customerList = customerService.searchByNameAndLastNames(name, firstLastName, secondLastName);
		// Mostrado de los clientes
		for (final Customer c : customerList) {
			LOG.info("Cliente {}: {} {}, {} --> Documento de Identidad: {}", c.getCustomerId(),
					c.getCustomerFirstLastName(), c.getCustomerSecondLastName(), c.getCustomerName(),
					c.getCustomerIdentityDocument());
		}
		// Cierre de la sesion
		session.close();
	}
}
