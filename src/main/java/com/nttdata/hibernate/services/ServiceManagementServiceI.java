package com.nttdata.hibernate.services;

import java.util.List;

import com.nttdata.hibernate.persistence.Service;

/**
 * Taller practico Hibernate - Taller 1
 * 
 * Interfaz del servicio de servicio
 * 
 * @author Gabriel Rodriguez Felix
 *
 */
public interface ServiceManagementServiceI {

	/**
	 * Metodo para insertar un nuevo Servicio
	 * 
	 * @param contract
	 */
	public void insertNewService(final Service service);

	/**
	 * Metodo para recoger todos los registros de servicios de la BBDD
	 * 
	 * @return List<Service>
	 */
	public List<Service> searchAll();

	/**
	 * Metodo para buscar un registro de servicio segun un id
	 * 
	 * @param serviceId
	 * @return Service
	 */
	public Service searchById(final Integer serviceId);

	/**
	 * Metodo para eliminar un Servicio de los registros de la BBDD
	 * 
	 * @param service
	 */
	public void deleteService(final Service service);

	/**
	 * Metodo para actualizar un Servicio de los registros de la BBDD
	 * 
	 * @param service
	 */
	public void updateService(final Service service);

	/**
	 * Metodo para obtener los servicios contratados por un cliente
	 * 
	 * @param customerIdentityDocument
	 * @return
	 */
	public List<Service> searchByContractId(Integer contractId);
}
