package com.nttdata.hibernate.persistence;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Taller práctico Hibernate - Taller 1
 * 
 * Entidad tabla NTTDATA_HT1_SERVICE
 * 
 * @author Gabriel Rodriguez Felix
 *
 */

@Entity
@Table(name = "NTTDATA_HT1_SERVICE")
public class Service extends AbstractEntity {

	// Serial Version
	private static final long serialVersionUID = 1L;

	// Identificador (Primary Key PK)
	private Integer serviceId;

	// Tipo del servicio
	private serviceType serviceType;

	// Contratos asociados al servicio
	private List<Contract> contractList;

	/**
	 * Metodo Getter de serviceId
	 * 
	 * @return serviceId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "serviceSequence")
	@SequenceGenerator(name = "serviceSequence", sequenceName = "NTTDATA_HT1_SERVICE_SEQUENCE")
	@Column(name = "SERVICE_ID")
	public Integer getServiceId() {
		return serviceId;
	}

	/**
	 * Metodo Setter de serviceId
	 * 
	 * @param serviceId
	 */
	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}

	/**
	 * Metodo Getter de serviceType
	 * 
	 * @return serviceType
	 */
	@Column(name = "SERVICE_TYPE")
	public serviceType getServiceType() {
		return serviceType;
	}

	/**
	 * Metodo Setter de serviceType
	 * 
	 * @param serviceType
	 */
	public void setServiceType(serviceType serviceType) {
		this.serviceType = serviceType;
	}

	/**
	 * Metodo Getter de contractList
	 * 
	 * @return contractList
	 */
	@ManyToMany(mappedBy = "servicesList")
	public List<Contract> getContractList() {
		return contractList;
	}

	/**
	 * Metodo Setter de servicesList
	 * 
	 * @param contractList
	 */
	public void setContractList(List<Contract> contractList) {
		this.contractList = contractList;
	}

	/**
	 * Metodo Getter de Class de Service
	 * 
	 * @return
	 */
	@Transient
	public Class<?> getServiceClass() {
		return Service.class;
	}

	@Override
	public Integer getId() {
		return this.serviceId;
	}

	@Override
	public void setId(Integer id) {
		this.serviceId = id;

	}

	@Override
	public String toString() {
		return "Service [serviceId=" + serviceId + ", serviceType=" + serviceType + ", contractList=" + contractList
				+ "]";
	}
	

}
