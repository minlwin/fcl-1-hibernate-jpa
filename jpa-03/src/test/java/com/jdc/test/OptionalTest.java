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
import com.jdc.pos.domain.entity.Item;

class OptionalTest {
	
	static EntityManagerFactory EMF;
	EntityManager em;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		EMF = Persistence.createEntityManagerFactory("jpa-03");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		EMF.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = EMF.createEntityManager();
		em.getTransaction().begin();
	}

	@AfterEach
	void tearDown() throws Exception {
		em.getTransaction().commit();
		em.close();
	}

	@Test
	void test() {
		Item item = new Item();
		item.setName("Coke");
		
		Category c = new Category();
		c.setName("Drink");
		item.setCategory(c);
		
		em.persist(item);
		
		assertEquals(1, item.getId());
	}

}
