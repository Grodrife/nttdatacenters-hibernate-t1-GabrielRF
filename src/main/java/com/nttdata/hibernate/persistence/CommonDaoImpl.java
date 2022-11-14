package com.nttdata.hibernate.persistence;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;

/**
 * Taller práctico Hibernate - Taller 1
 * 
 * Patron DAO Generico
 * 
 * @author Gabriel Rodriguez Felix
 *
 */
public abstract class CommonDaoImpl<T extends AbstractEntity> implements CommonDaoI<T> {

	// Tipo de Clase
	private Class<T> entityClass;
	// Sesion
	private Session session;

	/**
	 * Metodo constructor
	 * 
	 * @param session
	 */
	@SuppressWarnings("unchecked")
	protected CommonDaoImpl(Session session) {
		setEntityClass(
				(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
		this.session = session;
	}

	@Override
	public void insert(final T paramT) {
		// Comprobacion de sesion abierta
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}
		// Insercion y commit
		session.persist(paramT);
		session.flush();
		session.getTransaction().commit();
	}

	@Override
	@SuppressWarnings({ "unchecked" })
	public List<T> searchAll() {
		// Comprobacion de sesion abierta
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}
		// Devolucion de todos los registros
		return session.createQuery("FROM " + this.entityClass.getName()).list();
	}

	@Override
	public T searchById(final Integer id) {
		// Comprobacion de sesion abierta
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}
		return session.get(this.entityClass, id);
	}

	@Override
	public void delete(final T paramT) {
		// Comprobacion de sesion abierta
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}
		// Borrado de registro y commit en la BBDD
		session.remove(paramT);
		session.getTransaction().commit();
	}

	@Override
	public void update(final T paramT) {
		// Comprobacion de sesion abierta
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}
		// Guardado de registro y commit en la BBDD
		session.persist(paramT);
		session.getTransaction().commit();
	}

	/**
	 * Metodo Getter de entityClass
	 * 
	 * @return entityClass
	 */
	public Class<T> getEntityClass() {
		return entityClass;
	}

	/**
	 * Metodo Setter de entityClass
	 * 
	 * @param entityClass
	 */
	public void setEntityClass(Class<T> entityClass) {
		this.entityClass = entityClass;
	}
}
