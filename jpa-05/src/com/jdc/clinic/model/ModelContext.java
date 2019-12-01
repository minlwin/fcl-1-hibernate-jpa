package com.jdc.clinic.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ModelContext {
	
	private static EntityManagerFactory EMF;
	
	public static void init() {
		EMF = Persistence.createEntityManagerFactory("jpa-05");
	}
	
	public static void close() {
		EMF.close();
	}
	
	private ModelContext() {}
	
	private static ModelContext context = new ModelContext();
	
	public static ModelContext getContext() {
		return context;
	}
	
	public EntityManager getEntityManager() {
		return EMF.createEntityManager();
	}

}
