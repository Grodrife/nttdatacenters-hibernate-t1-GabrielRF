package com.nttdata.hibernate.persistence;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Taller práctico Hibernate - Taller 1
 * 
 * Entidad tabla NTTDATA_HT1_CUSTOMER
 * 
 * @author Gabriel Rodriguez Felix
 *
 */
@Entity
@Table(name = "NTTDATA_HT1_CUSTOMER")
public class Customer extends AbstractEntity {

	// Serial Version
	private static final long serialVersionUID = 1L;

	// Identificador (Primary Key PK)
	private Integer customerId;

	// Nombre del cliente
	private String customerName;

	// Primer apellido del cliente
	private String customerFirstLastName;

	// Segundo apellido del cliente
	private String customerSecondLastName;

	// Documento de identificacion del cliente
	private String customerIdentityDocument;

	// Contratos asociados al Cliente
	private List<Contract> customerContractList;

	/**
	 * Metodo Getter de customerId
	 * 
	 * @return customerId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customerSequence")
	@SequenceGenerator(name = "customerSequence", sequenceName = "NTTDATA_HT1_CUSTOMER_SEQUENCE")
	@Column(name = "CUSTOMER_ID")
	public Integer getCustomerId() {
		return customerId;
	}

	/**
	 * Metodo Setter de customerId
	 * 
	 * @param customerId
	 */
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	/**
	 * Metodo Getter de customerName
	 * 
	 * @return customerName
	 */
	@Column(name = "CUSTOMER_NAME")
	public String getCustomerName() {
		return customerName;
	}

	/**
	 * Metodo Setter de customerName
	 * 
	 * @param customerName
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	/**
	 * Metodo Getter de customerFirstLastName
	 * 
	 * @return customerFirstLastName
	 */
	@Column(name = "CUSTOMER_FIRST_LAST_NAME")
	public String getCustomerFirstLastName() {
		return customerFirstLastName;
	}

	/**
	 * Metodo Setter de customerFirstLastName
	 * 
	 * @param customerFirstLastName
	 */
	public void setCustomerFirstLastName(String customerFirstLastName) {
		this.customerFirstLastName = customerFirstLastName;
	}

	/**
	 * Metodo Getter de customerSecondLastName
	 * 
	 * @return customerSecondLastName
	 */
	@Column(name = "CUSTOMER_SECOND_LAST_NAME")
	public String getCustomerSecondLastName() {
		return customerSecondLastName;
	}

	/**
	 * Metodo Setter de customerSecondLastName
	 * 
	 * @param customerSecondLastName
	 */
	public void setCustomerSecondLastName(String customerSecondLastName) {
		this.customerSecondLastName = customerSecondLastName;
	}

	/**
	 * Metodo Getter de customerIdentityDocument
	 * 
	 * @return customerIdentityDocument
	 */
	@Column(name = "CUSTOMER_IDENTITY_DOCUMENT", nullable = false, unique = true)
	public String getCustomerIdentityDocument() {
		return customerIdentityDocument;
	}

	/**
	 * Metodo de Setter de customerIdentityDocument
	 * 
	 * @param customerIdentityDocument
	 */
	public void setCustomerIdentityDocument(String customerIdentityDocument) {
		this.customerIdentityDocument = customerIdentityDocument;
	}

	/**
	 * Metodo Getter de customerContractList
	 * 
	 * @return customerContractList
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "contractCustomer")
	public List<Contract> getCustomerContractList() {
		return customerContractList;
	}

	/**
	 * Metodo Setter de customerContractList
	 * 
	 * @param customerContractList
	 */
	public void setCustomerContractList(List<Contract> customerContractList) {
		this.customerContractList = customerContractList;
	}

	/**
	 * Metodo Getter de Class de Customer
	 * 
	 * @return class
	 */
	@Transient
	public Class<?> getCustomerClass() {
		return Customer.class;
	}

	@Override
	public Integer getId() {
		return this.customerId;
	}

	@Override
	public void setId(Integer id) {
		this.customerId = id;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerFirstLastName="
				+ customerFirstLastName + ", customerSecondLastName=" + customerSecondLastName
				+ ", customerIdentityDocument=" + customerIdentityDocument + "]";
	}

}
