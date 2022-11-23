package com.nttdata.hibernate.persistence;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

/**
 * Taller práctico Hibernate - Taller 1
 * 
 * Implementacion DAO de tabla NTTDATA_HT1_CUSTOMER
 * 
 * @author Gabriel Rodriguez Felix
 *
 */
public class ServiceDaoImpl extends CommonDaoImpl<Service> implements ServiceDaoI {

	// Sesion de contrato
	private Session session;

	/**
	 * Metodo constructor
	 * 
	 * @param session
	 */
	public ServiceDaoImpl(Session session) {
		super(session);
		this.session = session;
	}

	@Override
	public List<Service> searchByContractId(Integer contractId) {

		// Raiz de la consulta
		final CriteriaBuilder builder = session.getCriteriaBuilder();
		final CriteriaQuery<Service> query = builder.createQuery(Service.class);
		final Root<Service> queryRoot = query.from(Service.class);
		final Join<Service, Contract> joinQuery = queryRoot.join("contractList");

		// Elemento de WHERE
		final Predicate wherePredicateContractId = builder.equal(joinQuery.<Integer>get("contractId"), contractId);

		// Construccion de la consulta
		query.select(queryRoot).where(wherePredicateContractId);

		return session.createQuery(query).getResultList();
	}

}
