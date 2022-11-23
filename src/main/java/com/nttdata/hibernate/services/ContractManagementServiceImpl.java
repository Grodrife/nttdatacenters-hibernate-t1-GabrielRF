package com.nttdata.hibernate.services;

import java.util.List;

import org.hibernate.Session;

import com.nttdata.hibernate.persistence.Contract;
import com.nttdata.hibernate.persistence.ContractDaoI;
import com.nttdata.hibernate.persistence.ContractDaoImpl;

/**
 * Taller practico Hibernate - Taller 1
 * 
 * Implementacion servicio contrato
 * 
 * @author Gabriel Rodriguez Felix
 *
 */
public class ContractManagementServiceImpl implements ContractManagementServiceI {

	// DAO de contrato(NTTDATA_HT1_CONTRACT)
	private ContractDaoI contractDao;

	/**
	 * Metodo constructor del servicio de Contrato
	 * 
	 * @param session
	 */
	public ContractManagementServiceImpl(final Session session) {
		this.contractDao = new ContractDaoImpl(session);
	}

	@Override
	public void insertNewContract(Contract contract) {

		if (contract != null && contract.getContractId() == null) {
			contractDao.insert(contract);
		}
	}

	@Override
	public List<Contract> searchAll() {
		return contractDao.searchAll();
	}

	@Override
	public Contract searchById(Integer contractId) {
		return contractId != null ? contractDao.searchById(contractId) : null;
	}

	@Override
	public void deleteContract(Contract contract) {

		if (contract != null && contract.getContractId() == null) {
			contractDao.delete(contract);
		}
	}

	@Override
	public void updateContract(Contract contract) {

		if (contract != null && contract.getContractId() != null) {
			contractDao.update(contract);
		}
	}

	@Override
	public List<Contract> searchCurrentContracts() {
		return contractDao.searchCurrentContracts();
	}

	@Override
	public List<Contract> searchByCustomerIdentityDocument(String customerIdentityDocument) {

		return contractDao.searchByCustomerIdentityDocument(customerIdentityDocument);
	}

}
