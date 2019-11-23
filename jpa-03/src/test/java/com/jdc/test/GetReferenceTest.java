package com.jdc.test;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.jdc.pos.domain.entity.Category;

class GetReferenceTest {
	
	private static EntityManagerFactory EMF;
	private EntityManager em;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		EMF = Persistence.createEntityManagerFactory("jpa-03");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		EMF.close();
	}
	
	@BeforeEach
	void setUp() {
		em = EMF.createEntityManager();
		em.getTransaction().begin();
	}
	
	@AfterEach
	void tearDown() {
		em.getTransaction().commit();
		em.close();
	}

//	@Test
//	void test1_creation() {
//		Category c = new Category();
//		c.setName("Foods");
//		em.persist(c);
//	}
	
	@Test
	void test2_findById() {
		Category c = em.find(Category.class, 1);
		assertNull(c);
	}
	
	@Test
	void test3_getReference() {
		Category c = em.getReference(Category.class, 1);
		assertNotNull(c);
		assertTrue(em.contains(c));
	}

}
