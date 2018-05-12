package br.com.wcf.jpa.factory;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EntityManagerFactory {

	private static EntityManagerFactory INSTANCE;
	private static EntityManager emf;
	private static final Logger LOG4J = LoggerFactory.getLogger(EntityManagerFactory.class);

	private EntityManagerFactory() {
	}

	public static EntityManagerFactory getInstance() {

		if (INSTANCE == null) {
			synchronized (EntityManagerFactory.class) {
				if (INSTANCE == null) {
					INSTANCE = new EntityManagerFactory();
					LOG4J.debug("--> New Factory");
					System.out.println("--> New Factory");
				}
			}
		}

		return INSTANCE;

	}

	public EntityManager getEntityManagerFactory() {

		try {

			if (emf == null) {
				emf = Persistence.createEntityManagerFactory("PU").createEntityManager();
				System.out.println("--> Create EMF" + new Date());
				LOG4J.debug("--> Create EMF" + new Date());
			}

		} catch (Exception e) {
			// System.out.println(e.getMessage());
			e.printStackTrace();
			LOG4J.debug(e.getMessage());
		}

		return emf;

	}

	public void closeEmf() {

		if (emf.isOpen() || emf != null) {
			emf.close();
		}
		emf = null;
		LOG4J.debug("-->EMF closed at: " + new Date());
	}

}
