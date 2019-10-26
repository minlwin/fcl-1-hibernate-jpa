package com.jdc.tut1.test;

import static org.junit.Assert.*;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class DummyTest {
	
	static EntityManagerFactory EMF;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		EMF = Persistence.createEntityManagerFactory("jpa-01-mapping");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		EMF.close();
	}

	@Test
	public void test() {
		
	}

}
