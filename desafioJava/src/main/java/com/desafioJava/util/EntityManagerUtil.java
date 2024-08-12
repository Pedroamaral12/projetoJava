package com.desafioJava.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerUtil {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("desafioJavaPU");

	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
}
