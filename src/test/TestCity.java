package test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import main.City;

public class TestCity {
	
	@Test
	public void testCityConstructor() {
		City tc = new City("testCity");
		assertEquals("testCity", tc.name);
	}
	
}
