package com.nttdata.hibernate.services;

import java.util.List;

import org.hibernate.Session;

import com.nttdata.hibernate.persistence.Service;
import com.nttdata.hibernate.persistence.ServiceDaoI;
import com.nttdata.hibernate.persistence.ServiceDaoImpl;

/**
 * Taller practico Hibernate - Taller 1
 * 
 * Implementacion servicio servicio
 * 
 * @author Gabriel Rodriguez Felix
 *
 */
public class ServiceManagementServiceImpl implements ServiceManagementServiceI {

	// DAO de servicio(NTTDATA_HT1_SERVICE)
	private ServiceDaoI serviceDao;

	/**
	 * Metodo constructor del servicio de Servicio
	 * 
	 * @param session
	 */
	public ServiceManagementServiceImpl(final Session session) {
		this.serviceDao = new ServiceDaoImpl(session);
	}

	@Override
	public void insertNewService(Service service) {

		if (service != null && service.getServiceId() == null) {
			serviceDao.insert(service);
		}

	}

	@Override
	public List<Service> searchAll() {
		return serviceDao.searchAll();
	}

	@Override
	public Service searchById(Integer serviceId) {
		return serviceId != null ? serviceDao.searchById(serviceId) : null;
	}

	@Override
	public void deleteService(Service service) {

		if (service != null && service.getServiceId() == null) {
			serviceDao.delete(service);
		}

	}

	@Override
	public void updateService(Service service) {

		if (service != null && service.getServiceId() == null) {
			serviceDao.update(service);
		}

	}

	@Override
	public List<Service> searchByContractId(Integer contractId) {

		return serviceDao.searchByContractId(contractId);
	}

}
