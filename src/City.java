import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class City {
	
	String name;
	List<Flight> flights;
	
	public City(String n) {
		this.name = n;
		flights = new ArrayList<Flight>();
	}
	
}
