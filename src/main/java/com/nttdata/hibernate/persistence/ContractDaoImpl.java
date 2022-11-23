package com.nttdata.hibernate.persistence;

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
 * Implementacion DAO de tabla NTTDATA_HT1_CONTRACT
 * 
 * @author Gabriel Rodriguez Felix
 *
 */
public class ContractDaoImpl extends CommonDaoImpl<Contract> implements ContractDaoI {

	// Sesion de contrato
	private Session session;

	/**
	 * Metodo constructor
	 * 
	 * @param session
	 */
	public ContractDaoImpl(Session session) {
		super(session);
		this.session = session;
	}

	@Override
	public List<Contract> searchCurrentContracts() {

		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		return session.createQuery("FROM Contract WHERE contractEndDate > CURRENT_DATE").list();
	}

	@Override
	public List<Contract> searchByCustomerIdentityDocument(String customerIdentityDocument) {

		// Raiz de la consulta
		final CriteriaBuilder builder = session.getCriteriaBuilder();
		final CriteriaQuery<Contract> query = builder.createQuery(Contract.class);
		final Root<Contract> queryRoot = query.from(Contract.class);
		final Join<Contract, Customer> joinQuery = queryRoot.join("contractCustomer");

		// Elemento de la clausula WHERE
		final Predicate wherePredicateIdentityDocument = builder.like(joinQuery.<String>get("customerIdentityDocument"),
				customerIdentityDocument);

		// Construccion final de la consulta
		query.select(queryRoot).where(wherePredicateIdentityDocument);

		return session.createQuery(query).getResultList();
	}

}
