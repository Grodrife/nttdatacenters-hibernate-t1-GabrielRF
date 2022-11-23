package com.nttdata.hibernate.persistence;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Taller practico Hibernate - Taller 1
 * 
 * Entidad tabla NTTDATA_HT1_CONTRACT
 * 
 * @author Gabriel Rodriguez Felix
 *
 */
@Entity
@Table(name = "NTTDATA_HT1_CONTRACT")
public class Contract extends AbstractEntity {

	// Serial Version
	private static final long serialVersionUID = 1L;

	// Identificador (Primary Key PK)
	private Integer contractId;

	// Fecha de inicio del contrato
	private LocalDate contractDate;

	// Fecha de finalizacion del contrato
	private LocalDate contractEndDate;

	// Cuantia mensual del contrato
	private Double contractPayment;

	// Cliente asociado (Foreign Key FK)
	private Customer contractCustomer;

	// Servicios asociados al contrato
	private List<Service> servicesList;

	/**
	 * Metodo Getter de contractId
	 * 
	 * @return contractId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contractSequence")
	@SequenceGenerator(name = "contractSequence", sequenceName = "NTTDATA_HT1_CONTRACT_SEQUENCE")
	@Column(name = "CONTRACT_ID")
	public Integer getContractId() {
		return contractId;
	}

	/**
	 * Metodo Setter de contractId
	 * 
	 * @param contractId
	 */
	public void setContractId(Integer contractId) {
		this.contractId = contractId;
	}

	/**
	 * Metodo Getter de contractDate
	 * 
	 * @return contractDate
	 */
	@Column(name = "CONTRACT_DATE", nullable = false)
	public LocalDate getContractDate() {
		return contractDate;
	}

	/**
	 * Metodo Setter de contractDate
	 * 
	 * @param contractDate
	 */
	public void setContractDate(LocalDate contractDate) {
		this.contractDate = contractDate;
	}

	/**
	 * Metodo Getter de contractEndDate
	 * 
	 * @return contractEndDate
	 */
	@Column(name = "CONTRACT_END_DATE", nullable = false)
	public LocalDate getContractEndDate() {
		return contractEndDate;
	}

	/**
	 * Metodo Setter de contractEndDate
	 * 
	 * @param contractEndDate
	 */
	public void setContractEndDate(LocalDate contractEndDate) {
		this.contractEndDate = contractEndDate;
	}

	/**
	 * Metodo Getter de contractPayment
	 * 
	 * @return contractPayment
	 */
	@Column(name = "CONTRACT_PAYMENT")
	public Double getContractPayment() {
		return contractPayment;
	}

	/**
	 * Metodo Setter de contractPayment
	 * 
	 * @param contractPayment
	 */
	public void setContractPayment(Double contractPayment) {
		this.contractPayment = contractPayment;
	}

	/**
	 * Metodo Getter de contractCustomer
	 * 
	 * @return contractCustomer
	 */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CUSTOMER_ID")
	public Customer getContractCustomer() {
		return contractCustomer;
	}

	/**
	 * Metodo Setter de contractCustomer
	 * 
	 * @param contractCustomer
	 */
	public void setContractCustomer(Customer contractCustomer) {
		this.contractCustomer = contractCustomer;
	}

	/**
	 * Metodo Getter de serviceList
	 * 
	 * @return servicesList
	 */
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "NTTDATA_HT1_CONTRACT_SERVICE", joinColumns = @JoinColumn(name = "CONTRACT_ID"), inverseJoinColumns = @JoinColumn(name = "SERVICE_ID"))
	public List<Service> getServicesList() {
		return servicesList;
	}

	/**
	 * Metodo Setter de servicesList
	 * 
	 * @param servicesList
	 */
	public void setServicesList(List<Service> servicesList) {
		this.servicesList = servicesList;
	}

	/**
	 * Metodo Getter de Class de Contract
	 * 
	 * @return class
	 */
	@Transient
	public Class<?> getContractClass() {
		return Contract.class;
	}

	@Override
	public Integer getId() {
		return this.contractId;
	}

	@Override
	public void setId(Integer id) {
		this.contractId = id;
	}

	@Override
	public String toString() {
		return "Contract [contractId=" + contractId + ", contractDate=" + contractDate + ", contractEndDate="
				+ contractEndDate + ", contractPayment=" + contractPayment + ", contractCustomer=" + contractCustomer
				+ "]";
	}

}
