package models;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;

import tools.MD5;

class MyConnexionTest {

	@Test
	void testCheckUser() {
		
		SuperAdmin.addAdmin("testUnitaire1", "testUnitaire");
		SuperAdmin.addAdmin("testUnitaire2", "testUnitaire");
		assertTrue(MyConnexion.checkUser("testUnitaire1"));
		assertFalse(MyConnexion.checkUser("toto"));
		SuperAdmin.deleteAdmin("testUnitaire1");
		SuperAdmin.deleteAdmin("testUnitaire2");
	}
	
	@Test
	void testCheckId() {
	
		SuperAdmin.addAdmin("testUnitaire1", "testUnitaire");
		SuperAdmin.addAdmin("testUnitaire2", "testUnitaire");
		assertTrue(MyConnexion.checkId("testUnitaire2", MD5.main("testUnitaire")));
		assertFalse(MyConnexion.checkId("toto", MD5.main("testUnitaire")));
		SuperAdmin.deleteAdmin("testUnitaire1");
		SuperAdmin.deleteAdmin("testUnitaire2");
	}
}
