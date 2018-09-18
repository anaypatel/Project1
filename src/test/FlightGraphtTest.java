package test;

import static org.junit.Assert.assertEquals;

import main.City;
import main.FlightGraph;
import main.Flight;

public class FlightGraphtTest {
	
	public static FlightGraph createTestFlightGraph() {
		FlightGraph fg = new FlightGraph("testOrigin");
		
		City testOriginCity = new City("testOrigin");
		City c1 = new City("testCity1");
		City c2 = new City("testCity2");
		City c3 = new City("testCity3");
		
		Flight f1 = new Flight("testOrigin", "testCity1", 500);
		Flight f2 = new Flight("testCity1", "testCity2", 1000);
		Flight f3 = new Flight ("testCity2", "testCity3", 350);
		
		testOriginCity.flights.add(f1);
		testOriginCity.flights.add(f2);
		testOriginCity.flights.add(f3);
		
		fg.cityMap.put("testCity1", c1);
		fg.cityMap.put("testCity2", c2);
		fg.cityMap.put("testCity3", c3);

		return fg;
		
	}
		
	public void testFlightGraphConstructor() {
		FlightGraph fg = new FlightGraph("testOrigin");
		assertEquals("testOrigin", fg.origin);
	}
	
	public void testPath() {
		FlightGraph fg = createTestFlightGraph();
		fg.path(fg.cityMap.get("testOrigin"));
		
		assertEquals("origin", fg.paths.get("testOrigin"));
		assertEquals("testOrigin", fg.paths.get("testCity1"));
		assertEquals("testOrigin", fg.paths.get("testCity2"));
		assertEquals("testOrigin", fg.paths.get("testCity3"));
		
	}
	
	public void testPathFinder() {
		FlightGraph fg = createTestFlightGraph();
		fg.path(fg.cityMap.get("testOrigin"));
		
		assertEquals("testOrigin, testCity1", fg.path_finder("testCity1"));
		assertEquals("testOrigin, testCity1, testCity2", fg.path_finder("testCity2"));
		assertEquals("testOrigin, testCity1, testCity2, testCity3", fg.path_finder("testCity3"));
	
	}
	
	@SuppressWarnings("deprecation")
	public void testPathCost() {
		FlightGraph fg = createTestFlightGraph();
		fg.path(fg.cityMap.get("testOrigin"));
		
		assertEquals(500, Double.parseDouble(fg.path_cost("testCity1")));
		assertEquals(1500, Double.parseDouble(fg.path_cost("testCity2")));
		assertEquals(1850, Double.parseDouble(fg.path_cost("testCity3")));
		
	}
	
}
