package main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class FlightGraph {
	
	public Map<String, City> cityMap; // keeps track of all cities using their string name as key
	public String origin; // keeps track of the origin of the journey
	public Map<String, String> paths; // keeps track of potential flight paths
	
	/**
	 * This is the FlightGraph class, that helps keep track of all the cities, all possible paths between
	 * cities, and the name of the origin city.
	 * @param o = origin city name
	 */
	
	public FlightGraph(String o) {
		this.origin = o;
		cityMap = new HashMap<String, City>();
		paths = new HashMap<String, String>();
		paths.put(origin, "origin");
	}
	
	/**
	 * This function performs depth first search and records possible paths to different cities.
	 * @param c = The origin city for finding all possible paths to other cities.
	 */
	
	public void path(City c) {
		List<Flight> flights = c.flights;
		c.visited = true;

		for(Flight f : flights) {
			City dest = cityMap.get(f.dest);
			if(!dest.visited) {
				paths.put(dest.name, c.name);
				path(dest);
			}
		}	
	}
	
	/**
	 * This function constructs a path from the origin to a given city.
	 * @param s = name of the final destination of the path you are searching for
	 * @return a String that is a correctly formatted path to the city 's'.
	 */
	
	public String path_finder(String s) {
		// Use a stack to keep track of the path from the city "s" to the origin
		Stack<String> path = new Stack<String>();
		String curr = s;
		String output = "";
		
		// Find the flight path in paths until the origin is reached, push it to the path stack
		while(curr != "origin") {
			path.push(curr);
			curr = paths.get(curr);
		}
		
		// Backtrack through the stack until the destination is reached
		while(!path.isEmpty()) {
			output += path.pop();
			output += ",";
		}
		
		// Return the output string, minus the comma at the end
		return output.substring(0, output.length() - 1);
	}
	
	/**
	 * This function returns the cost it takes to travel to a given city.
	 * @param s = name of the final destination that you want the cost of reaching
	 * @return a String that represents the cost of traveling to city 's'.
	 */
	
	public String path_cost(String s) {
		double cost = 0;
		String curr = s;
		
		while(!paths.get(curr).equals("origin")) {
			String next = paths.get(curr);
			for(Flight f : cityMap.get(next).flights) {
				if(f.dest.equals(curr)) {
					cost += f.cost;
					break;
				}
			}
			curr = paths.get(curr);
		}
		
		return Double.toString(cost);
	}
	
}
