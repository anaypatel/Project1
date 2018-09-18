package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class City {
	
	public String name;
	public List<Flight> flights;
	public boolean visited;
	
	/**
	 * This is the City object, which stores the name of the city, and contains a list of outgoing Flights
	 * from the City, as well as a boolean to see whether or not the city has been visited in depth first search.
	 * @param n = name of the given city
	 */
	
	public City(String n) {
		this.name = n;
		flights = new ArrayList<Flight>();
		visited = false;
	}
	
}
