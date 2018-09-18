package main;

public class Flight {
		
	public String source;
	public String dest;
	public double cost;
	
	/**
	 * This is the Flight object, which stores the names of two cities and the cost of one flight between them. 
	 * @param s = name of the source city
	 * @param d = name of the destination city
	 * @param c = cost of the flight
	 */
	
	public Flight(String s, String d, double c) {
		this.source = s;
		this.dest = d;
		this.cost = c;
	}
		
}