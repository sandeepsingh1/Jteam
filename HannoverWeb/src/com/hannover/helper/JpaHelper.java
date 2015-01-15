package com.hannover.helper;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaHelper {
	
	public static EntityManager getEntityManager(){
		  Map<String, String> properties = new HashMap<String, String>();
		  properties.put("javax.persistence.jdbc.user", "postgres");
		  properties.put("javax.persistence.jdbc.password", "postgres");
		  EntityManagerFactory  emf = Persistence.createEntityManagerFactory("jdbc:postgresql://localhost:5432/hannover", properties);
		  return emf.createEntityManager();
	}
}
