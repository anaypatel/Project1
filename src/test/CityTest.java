package test;

import static org.junit.Assert.assertEquals;

import main.City;

public class CityTest {
	
	public void testCityConstructor() {
		City tc = new City("testCity");
		assertEquals("testCity", tc.name);
	}
	
}
