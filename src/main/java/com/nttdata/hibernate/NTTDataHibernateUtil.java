package com.nttdata.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * Taller práctico Hibernate - Taller 1
 * 
 * Clase de configuracion
 * 
 * @author Gabriel Rodriguez Felix
 *
 */
public class NTTDataHibernateUtil {

	// Logger
	private static final Logger LOG = LoggerFactory.getLogger(NTTDataHibernateUtil.class);

	private static final SessionFactory SESSION_FACTORY;

	/**
	 * Metodo constructor
	 */
	private NTTDataHibernateUtil() {

	}

	static {
		try {
			SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
		} catch (final Exception ex) {
			LOG.error("[ERROR] Configuración de Hibernate - " + ex);
			throw new ExceptionInInitializerError();
		}
	}

	public static SessionFactory getSessionFactory() {
		return SESSION_FACTORY;
	}
}
