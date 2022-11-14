package com.nttdata.hibernate.persistence;

import java.util.List;

/**
 * Taller práctico Hibernate - Taller 1
 * 
 * Patron DAO Generico
 * 
 * @author Gabriel Rodriguez Felix
 *
 */
public interface CommonDaoI<T> {

	/**
	 * Metodo para insertar un registro
	 * 
	 * @param paramT
	 */
	public void insert(final T paramT);

	/**
	 * Metodo para consultar todos
	 * 
	 * @return
	 */
	public List<T> searchAll();

	/**
	 * Metodo para consultar por ID
	 * 
	 * @param id
	 * @return Objeto T
	 */
	public T searchById(final Integer id);

	/**
	 * Metodo para borrar un registro
	 * 
	 * @param paramT
	 */
	public void delete(final T paramT);

	/**
	 * Metodo para actualizar un registro
	 * 
	 * @param paramT
	 */
	public void update(final T paramT);
}
