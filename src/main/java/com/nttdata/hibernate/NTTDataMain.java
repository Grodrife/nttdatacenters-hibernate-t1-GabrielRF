package com.nttdata.hibernate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nttdata.hibernate.persistence.Contract;
import com.nttdata.hibernate.persistence.Customer;
import com.nttdata.hibernate.persistence.Service;
import com.nttdata.hibernate.persistence.serviceType;
import com.nttdata.hibernate.services.ContractManagementServiceI;
import com.nttdata.hibernate.services.ContractManagementServiceImpl;
import com.nttdata.hibernate.services.CustomerManagementServiceI;
import com.nttdata.hibernate.services.CustomerManagementServiceImpl;
import com.nttdata.hibernate.services.ServiceManagementServiceI;
import com.nttdata.hibernate.services.ServiceManagementServiceImpl;

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

		// Creacion de la sesion
		final Session session = NTTDataHibernateUtil.getSessionFactory().openSession();

		// Creacion del servicio para Cliente
		final CustomerManagementServiceI customerService = new CustomerManagementServiceImpl(session);

		// Creacion del servicio para Contrato
		final ContractManagementServiceI contractService = new ContractManagementServiceImpl(session);

		// Creacion del servicio para Servicio
		final ServiceManagementServiceI serviceService = new ServiceManagementServiceImpl(session);

		// Datos de auditoria
		final String updatedUser = "NTTDATA_GRF";
		final Date updatedDate = new Date();

		// Inicio generacion e insercion de clientes
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
		fourthCustomer.setCustomerName(name);
		fourthCustomer.setCustomerFirstLastName(firstLastName);
		fourthCustomer.setCustomerSecondLastName(secondLastName);
		fourthCustomer.setCustomerIdentityDocument("44444444D");
		fourthCustomer.setUpdatedUser(updatedUser);
		fourthCustomer.setUpdatedDate(updatedDate);
		// Cuarto cliente - Fin

		// Fin generacion e insercion de Clientes

		// Inicio generacion de Contratos
		// Primer contrat - Inicio
		Contract firstContract = new Contract();
		firstContract.setContractDate(LocalDate.of(2022, 10, 23));
		firstContract.setContractEndDate(LocalDate.of(2024, 5, 10));
		firstContract.setContractPayment(43.30);
		firstContract.setContractCustomer(firstCustomer);
		firstContract.setUpdatedUser(updatedUser);
		firstContract.setUpdatedDate(updatedDate);
		// Primer contrato - Fin

		// Segundo contrato - Inicio
		Contract secondContract = new Contract();
		secondContract.setContractDate(LocalDate.of(2022, 5, 17));
		secondContract.setContractEndDate(LocalDate.of(2025, 12, 6));
		secondContract.setContractPayment(28.90);
		secondContract.setContractCustomer(firstCustomer);
		secondContract.setUpdatedUser(updatedUser);
		secondContract.setUpdatedDate(updatedDate);
		// Segundo contrato - Fin

		// Tercer contrato - Inicio
		Contract thirdContract = new Contract();
		thirdContract.setContractDate(LocalDate.of(2017, 4, 5));
		thirdContract.setContractEndDate(LocalDate.of(2021, 7, 8));
		thirdContract.setContractPayment(17.85);
		thirdContract.setContractCustomer(thirdCustomer);
		thirdContract.setUpdatedUser(updatedUser);
		thirdContract.setUpdatedDate(updatedDate);
		// Tercer contrato - Fin
		// Fin generacion de Contratos

		// Fin generacion e insercion de Contratos

		// Inicio generacion de Servicios
		// Primer servicio - Inicio
		Service firstService = new Service();
		firstService.setServiceType(serviceType.ADSL);
		firstService.setUpdatedUser(updatedUser);
		firstService.setUpdatedDate(updatedDate);
		// Primer servicio - Fin

		// Segundo servicio - Inicio
		Service secondService = new Service();
		secondService.setServiceType(serviceType.FIBRA);
		secondService.setUpdatedUser(updatedUser);
		secondService.setUpdatedDate(updatedDate);
		// Segundo servicio - Fin

		// Tercer servicio - Inicio
		Service thirdService = new Service();
		thirdService.setServiceType(serviceType.TV);
		thirdService.setUpdatedUser(updatedUser);
		thirdService.setUpdatedDate(updatedDate);
		// Tercer servicio - Fin

		// Cuarto servicio - Inicio
		Service forthService = new Service();
		forthService.setServiceType(serviceType.FIJO);
		forthService.setUpdatedUser(updatedUser);
		forthService.setUpdatedDate(updatedDate);
		// Cuarto servicio - Fin

		// Quinto servicio - Inicio
		Service fifthService = new Service();
		fifthService.setServiceType(serviceType.MOVIL);
		fifthService.setUpdatedUser(updatedUser);
		fifthService.setUpdatedDate(updatedDate);
		// Quinto servicio - Fin

		// Vinculacion Servicio-Contrato
		// Contrato 1
		List<Service> firstContractServicesList = new ArrayList<>();
		firstContractServicesList.add(firstService);
		firstContractServicesList.add(thirdService);
		firstContract.setServicesList(firstContractServicesList);

		// Contrato 3
		List<Service> thirdContractServicesList = new ArrayList<>();
		thirdContractServicesList.add(secondService);
		thirdContractServicesList.add(forthService);
		thirdContractServicesList.add(fifthService);
		thirdContract.setServicesList(thirdContractServicesList);

		// Contrato 2
		List<Service> secondContractServiceList = new ArrayList<>();
		secondContractServiceList.add(secondService);
		secondContractServiceList.add(fifthService);
		secondContract.setServicesList(secondContractServiceList);

		// Insercion datos - Inicio
		// Insercion clientes
		customerService.insertNewCustomer(firstCustomer);
		customerService.insertNewCustomer(secondCustomer);
		customerService.insertNewCustomer(thirdCustomer);
		customerService.insertNewCustomer(fourthCustomer);

		// Insercion Servicios
		serviceService.insertNewService(firstService);
		serviceService.insertNewService(secondService);
		serviceService.insertNewService(thirdService);
		serviceService.insertNewService(forthService);
		serviceService.insertNewService(fifthService);

		// Insercion Contratos
		contractService.insertNewContract(firstContract);
		contractService.insertNewContract(secondContract);
		contractService.insertNewContract(thirdContract);
		// Insercion datos - Fin

		// Consultas
		List<Customer> customerList = customerService.searchByNameAndLastNames(name, firstLastName, secondLastName);
		// Mostrado de los clientes
		// Ejemplo de mostrado: Cliente 1: Apellido1, Apellido2, Nombre --> Documento de
		// Identidad: 11111111A
		LOG.info("CLIENTES LLAMADOS {} {} {}:", name, firstLastName, secondLastName);
		for (final Customer c : customerList) {
			LOG.info("Cliente {}: {} {}, {} --> Documento de Identidad: {}", c.getCustomerId(),
					c.getCustomerFirstLastName(), c.getCustomerSecondLastName(), c.getCustomerName(),
					c.getCustomerIdentityDocument());
		}

		// Mostrado de los contratos
		List<Contract> contractList = contractService.searchAll();

		// Ejemplo de mostrado: Contrato 1: 01/01/2022, 31/12/2022, 50€ Cliente 1
		LOG.info("CONTRATOS REGISTRADOS:");
		for (final Contract c : contractList) {
			LOG.info("Contrato {}: {}, {}, {}€ \t Cliente {}", c.getContractId(), c.getContractDate(),
					c.getContractEndDate(), c.getContractPayment(), c.getContractCustomer().getCustomerId());
		}

		// Mostrado de contratos vigentes
		List<Contract> currentContractsList = contractService.searchCurrentContracts();
		LOG.info("CONTRATOS VIGENTES(FECHA CONTRATACION, FECHA VENCIMIENTO, CUOTA MENSUAL, CLIENTE)");

		// Ejemplo de mostrado: Contrato 1: 01/01/2022, 31/12/2022, 50€ Cliente 1
		for (final Contract c : currentContractsList) {
			LOG.info("Contrato {}: {}, {}, {}€ \t Cliente {}", c.getContractId(), c.getContractDate(),
					c.getContractEndDate(), c.getContractPayment(), c.getContractCustomer().getCustomerId());
		}

		// Mostrado de contratos del cliente con DNI especifico
		List<Contract> contractsByCustomerIdentityDocument = contractService
				.searchByCustomerIdentityDocument("11111111A");
		LOG.info("CONTRATOS DEL CLIENTE CON DNI 11111111A");
		// Ejemplo de mostrado: Contrato 1: 01/01/2022, 31/12/2022, 50€
		for (final Contract c : contractsByCustomerIdentityDocument) {
			LOG.info("Contrato {}: {}, {}, {}€", c.getContractId(), c.getContractDate(), c.getContractEndDate(),
					c.getContractPayment());
		}

		// Mostrado de clientes que tengan un contrato que finalice antes de una fecha
		// especifica
		List<Customer> customerEndBeforeDate = customerService.searchCustomerEndBeforeDate(LocalDate.of(2024, 6, 1));
		LOG.info("CLIENTES QUE FINALIZAN SU CONTRATO ANTES DE 01/06/2024");
		// Ejemplo de mostrado: Cliente 1: Apellido1, Apellido2, Nombre --> Documento de
		// Identidad: 11111111A
		for (final Customer c : customerEndBeforeDate) {
			LOG.info("Cliente {}: {} {}, {} --> Documento de Identidad: {}", c.getCustomerId(),
					c.getCustomerFirstLastName(), c.getCustomerSecondLastName(), c.getCustomerName(),
					c.getCustomerIdentityDocument());
		}

		// Mostrado de Servicios contratados en un contrato
		List<Service> serviceFromContract = serviceService.searchByContractId(2);
		LOG.info("SERVICIOS CONTRATADOS EN EL CONTRATO 2");
		// Ejemplo de mostrado: Servicio 1 --> Tipo 1
		for (final Service s : serviceFromContract) {
			LOG.info("Servicio {} --> Tipo {}", s.getServiceId(), s.getServiceType());
		}

		// Cierre de la sesion
		session.close();
	}
}
