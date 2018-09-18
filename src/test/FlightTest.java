package test;

import static org.junit.Assert.assertEquals;

import main.Flight;

public class FlightTest {
	
	@SuppressWarnings("deprecation")
	public void testFlightConstructor() {
		Flight tf = new Flight("testSource", "testDest", 100.0);
		assertEquals("testSource", tf.source);
		assertEquals("testDest", tf.dest);
		assertEquals(100.0, tf.cost);
	}
	
}
