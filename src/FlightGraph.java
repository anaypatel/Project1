import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FlightGraph {
	
	Map<String, City> cityMap;
	String origin;
	String outfile;
	
	public FlightGraph(String o, String of) {
		this.origin = o;
		this.outfile = of;
		cityMap = new HashMap<String, City>();
	}
	
}
