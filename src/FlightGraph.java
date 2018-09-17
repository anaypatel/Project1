import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class FlightGraph {
	
	public Map<String, City> cityMap;
	public String origin;
	public String outfile;
	public Map<String, String> paths;
	
	public FlightGraph(String o, String of) {
		this.origin = o;
		this.outfile = of;
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
			output += ", ";
		}
		
		return output;
	}
	
	public String path_cost(String s) {
		String output = "";
		
		return output;
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
