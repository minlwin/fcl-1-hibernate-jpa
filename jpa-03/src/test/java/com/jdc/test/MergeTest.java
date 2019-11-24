package com.jdc.test;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.jdc.pos.domain.entity.Category;

@TestMethodOrder(MethodOrderer.Alphanumeric.class)
class MergeTest {
	
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
	void test1_create() {
		Category c = new Category();
		c.setName("Foods");
		c.setRemark("General Foods");
		
		em.persist(c);
		assertEquals(1, c.getId());
	}
	
	@Test
	void test2_merge_detach() {
		
		Category c = em.find(Category.class, 1);
		em.detach(c);
		
		c.setName("Drinks");
		em.merge(c);
		
		em.getTransaction().commit();
		em.clear();
		
		em.getTransaction().begin();
		c = em.find(Category.class, 1);
		
		assertEquals("Drinks", c.getName());
		
	}
	
	@Test
	void test3_merge_new() {
		
		Category c = new Category();
		c.setName("Hot Drinks");
		c.setRemark("Test Remark");
		
		c = em.merge(c);
		
		assertNotEquals(0, c.getId());
		assertTrue(em.contains(c));
		
	}
	
	@Test
	void test4_merge_manage() {
		Category c = em.find(Category.class, 1);
		em.merge(c);
		
		assertEquals(1, c.getId());
	}

	@Test
	void test5_merge_removed() {
		Category c = em.find(Category.class, 1);
		em.remove(c);
		
		em.getTransaction().commit();
		em.clear();
		
		em.getTransaction().begin();
		
		em.merge(c);
		
		em.getTransaction().commit();
		em.clear();
		
		em.getTransaction().begin();
		c = em.find(Category.class, 3);
		assertNotNull(c);
	}
}
