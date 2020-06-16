package ns4.test.junit5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ns4.model.Dron;

class DronTest {

	Dron objectoDron_test = new Dron();
	
	
	/**
	 * This test consists in evaluating the default values declared in the constructor of the class Drone when it is created a object of this class
	 */
	@Test
	void testDron() {
		int posX=0;
		int posy=0;
		String direction="Norte";
				
	 assertAll(
		      "Object Contructor Drone",
		      () -> assertEquals(posX,objectoDron_test.getPosx()),
		      () -> assertEquals(posy,objectoDron_test.getPosy()),
		      () -> assertEquals(direction, objectoDron_test.getDirection())
		    );
	}

	
	/**
	 * This test consists in evaluating  the correct function of method called "getPosx"  and the correct primitive type that return this method
	 */
	@Test
	void testGetPosx() {
		long val_test_axisX=objectoDron_test.getPosx();
		
		assertTrue(val_test_axisX==0 , "True");
		assertFalse(val_test_axisX==1, "False");
	}
	

	/**
	 * This test consists in evaluating  the correct function of method called "getPosy"  and the correct primitive type that return this method
	 */
	@Test
	void testGetPosy() {
		long val_test_axisY=objectoDron_test.getPosy();
		
		assertTrue(val_test_axisY==0 , "True");
		assertFalse(val_test_axisY==1, "False");
	}
	
	
	/**
	 * This test consists in evaluating the correct function of method called "getDirection" and the correct function of the method called "setDirection" 
	 */
	@Test
	void testGetDirection() {
		String actual_dir = "Norte";
		assertTrue(objectoDron_test.getDirection().equals(actual_dir) , "True");
		
		objectoDron_test.setDirection("sur");
		
		assertFalse(objectoDron_test.getDirection().equals(actual_dir) , "False");
	
	}
	
	
	
	/**
	 * This test consists in to create two object form the same class Drone, and compare if the method called "ToString" is functioning equals to both
	 */
	@Test
	void testToString() {
		Dron object1 = new Dron();
		Dron object2 = new Dron();
		
		object1.toString();
		object2.toString();
	
		assertEquals(object1.toString(), object2.toString());	
	}
}