package com.nttdata.hibernate.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * Taller práctico Hibernate - Taller 1
 * 
 * Clase Abstracta Generica
 * 
 * @author Gabriel Rodriguez Felix
 *
 */
@MappedSuperclass
public abstract class AbstractEntity implements Serializable {

	/** Serial Version */
	private static final long serialVersionUID = 1L;

	/** Auditoria - Usuario que actualiza */
	private String updatedUser;

	/** Auditoria - Fecha de actualizacion */
	private Date updatedDate;

	/**
	 * Metodo Getter de id
	 * 
	 * @return id
	 */
	public abstract Integer getId();

	/**
	 * Metodo Setter de id
	 * 
	 * @param id
	 */
	public abstract void setId(final Integer id);

	/**
	 * Metodo Getter de updatedUser
	 * 
	 * @return updatedUser
	 */
	@Column(name = "UPDATED_USER", nullable = false)
	public String getUpdatedUser() {
		return this.updatedUser;
	}

	/**
	 * Metodo Setter de updatedUser
	 * 
	 * @param updatedUser
	 */
	public void setUpdatedUser(String updatedUser) {
		this.updatedUser = updatedUser;
	}

	/**
	 * Metodo Getter de updatedDate
	 * 
	 * @return updatedDate
	 */
	@Column(name = "UPDATED_DATE", nullable = false)
	public Date getUpdatedDate() {
		return updatedDate;
	}

	/**
	 * Metodo Setter de updatedDate
	 * 
	 * @param updatedDate
	 */
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

}
