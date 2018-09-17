import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class FlightGraph {
	
	public Map<String, City> cityMap;
	public String origin;
	public Map<String, String> paths;
	
	public FlightGraph(String o) {
		this.origin = o;
		cityMap = new HashMap<String, City>();
		paths = new HashMap<String, String>();
		paths.put(origin, "origin");
	}
	
	public String path_finder(String s) {
		Stack<String> path = new Stack<String>();
		String curr = s;
		String output = "";

		while(curr != "origin") {
			path.push(curr);
			curr = paths.get(curr);
		}
		
		while(!path.isEmpty()) {
			output += path.pop();
			output += ",";
		}
		
		return output.substring(0, output.length() - 1);
	}
	
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
	
}
