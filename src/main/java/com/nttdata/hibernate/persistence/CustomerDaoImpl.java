package com.nttdata.hibernate.persistence;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

/**
 * Taller practico Hibernate - Taller 1
 * 
 * Implementacion DAO de tabla NTTDATA_HT1_CUSTOMER
 * 
 * @author Gabriel Rodriguez Felix
 *
 */
public class CustomerDaoImpl extends CommonDaoImpl<Customer> implements CustomerDaoI {

	// Sesion de cliente
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

	@Override
	public List<Customer> searchCustomerEndBeforeDate(LocalDate contractEndDate) {

		// Raiz de la consulta
		final CriteriaBuilder builder = session.getCriteriaBuilder();
		final CriteriaQuery<Customer> query = builder.createQuery(Customer.class);
		final Root<Customer> queryRoot = query.from(Customer.class);
		final Join<Customer, Contract> joinQuery = queryRoot.join("customerContractList");

		// Elementos de la clausula Where
		final Predicate wherePredicateEndDate = builder.lessThan(joinQuery.<LocalDate>get("contractEndDate"),
				contractEndDate);
		final Predicate wherePredicateEndDate2 = builder.greaterThan(joinQuery.<LocalDate>get("contractEndDate"),
				LocalDate.now());

		// Construccion final de la consulta
		query.select(queryRoot).where(builder.and(wherePredicateEndDate, wherePredicateEndDate2));

		return session.createQuery(query).getResultList();
	}

}
