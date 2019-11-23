
package com.jdc.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.jdc.pos.domain.entity.Category;

class JpaEntityTest {
	
	static EntityManagerFactory emf;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("jpa-03");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@Test
	void test1_Insert() {

		EntityManager em = emf.createEntityManager();

		try {
			// Transient State or New State
			Category c = new Category();
			c.setName("Foods");
			
			// begin transaction
			em.getTransaction().begin();
			
			// Insert to db
			em.persist(c);
			
			c.setRemark("Daily Foods");
			
			em.flush();
			
			em.detach(c);
			// detached state
			
			// commit transaction
			em.getTransaction().commit();
			
			c.setName("Other Name");
			// change manage state
			em.merge(c);
			
			em.getTransaction().begin();
			em.getTransaction().commit();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			
			Category c = em.find(Category.class, 1);
			
			if(null != c) {
				em.getTransaction().begin();
				c.getSecurity().setCreateUser("Admin");
				c.getSecurity().setUpdateUser("Admin");
				c.getSecurity().setCreation(LocalDateTime.now());
				c.getSecurity().setModification(LocalDateTime.now());
				em.getTransaction().commit();
				
				em.remove(c);
				em.getTransaction().begin();
				em.getTransaction().commit();
			}
			em.close();
		}
		

	}

}
