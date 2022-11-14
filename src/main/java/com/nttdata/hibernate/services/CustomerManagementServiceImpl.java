package com.nttdata.hibernate.services;

import java.util.List;

import org.hibernate.Session;

import com.nttdata.hibernate.persistence.Customer;
import com.nttdata.hibernate.persistence.CustomerDaoI;
import com.nttdata.hibernate.persistence.CustomerDaoImpl;

/**
 * Taller practico Hibernate - Taller 1
 * 
 * Implementacion servicio cliente
 * 
 * @author Gabriel Rodriguez Felix
 *
 */
public class CustomerManagementServiceImpl implements CustomerManagementServiceI {

	/** DAO de cliente(NTTDATA_HT1_CUSTOMER) */
	private CustomerDaoI customerDao;

	/**
	 * Metodo constructor
	 * 
	 * @param session
	 */
	public CustomerManagementServiceImpl(final Session session) {
		this.customerDao = new CustomerDaoImpl(session);
	}

	@Override
	public void insertNewCustomer(Customer customer) {

		if (customer != null && customer.getId() == null) {
			customerDao.insert(customer);
		}

	}

	@Override
	public List<Customer> searchAll() {
		return customerDao.searchAll();
	}

	@Override
	public Customer searchById(Integer customerId) {

		return customerId != null ? customerDao.searchById(customerId) : null;
	}

	@Override
	public void deleteCustomer(Customer customer) {

		if (customer != null && customer.getCustomerId() != null) {
			customerDao.delete(customer);
		}

	}

	@Override
	public void updateCustomer(Customer customer) {

		if (customer != null && customer.getCustomerId() != null) {
			customerDao.delete(customer);
		}

	}

	@Override
	public List<Customer> searchByNameAndLastNames(String customerName, String customerFirstLastName,
			String customerSecondLastName) {

		return customerDao.searchByNameAndLastNames(customerName, customerFirstLastName, customerSecondLastName);
	}

}
