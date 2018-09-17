import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class City {
	
	public String name;
	public List<Flight> flights;
	public boolean visited;
	
	public City(String n) {
		this.name = n;
		flights = new ArrayList<Flight>();
		visited = false;
	}
	
}
