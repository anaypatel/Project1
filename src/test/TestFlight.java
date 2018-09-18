package test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import main.Flight;

public class TestFlight {
	
	@SuppressWarnings("deprecation")
	@Test
	public void testFlightConstructor() {
		Flight tf = new Flight("testSource", "testDest", 100.0);
		assertEquals("testSource", tf.source);
		assertEquals("testDest", tf.dest);
		assertEquals(100.0, tf.cost);
	}
	
}
