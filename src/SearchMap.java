import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class SearchMap {

	public static void main(String[] args) {
		
		// Check that the user has entered infile and outfile names
		if(args.length != 2) {
			System.out.println("Invalid arguments");
			return;
		}
		
		// Store names of infile and outfile
		String infile = args[0];
		String outfile = args[1];
		
		// Parse the infile using FileReader/BufferedReader
		String line = null;
		try {
            FileReader fr = new FileReader(infile);
            BufferedReader br = new BufferedReader(fr);
            
            // Record the first line as the origin
            String origin = br.readLine();
            
            // Source, destination, and cost to be recorded on every subsequent line
            String source, dest;
            double cost;
            
            // Create a new graph of flights and put the origin in the cityMap
            FlightGraph flight_graph = new FlightGraph(origin, outfile);
            flight_graph.cityMap.put(origin, new City(origin));
            
            // Go through every line of the file
            while((line = br.readLine()) != null) {
            		
            		// Split the line on spaces
                String[] splitted_line = line.split(" ");
                // Store the three pieces of info on each line
                source = splitted_line[0];
                dest = splitted_line[1];
                cost = Double.parseDouble(splitted_line[2]);         
                // Create a new flight using that information
                Flight f = new Flight(source, dest, cost);
                                
                // Check to see if the source city already exists, if not adds it to the cityMap
                if(flight_graph.cityMap.get(source) != null) {
                		flight_graph.cityMap.get(source).flights.add(f);
                }else {
                		flight_graph.cityMap.put(source, new City(source));
                		flight_graph.cityMap.get(source).flights.add(f);
                }
                // Check to see if the dest city already exists, if not adds it to the cityMap
                if(flight_graph.cityMap.get(dest) == null) {
            			flight_graph.cityMap.put(dest, new City(dest));
                }
                
            }
            
            // Close the BufferedReader
            br.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file " + infile);                
        }
        catch(IOException ex) {
            System.out.println("Error reading file " + infile);                  
        }
		
		
		
	}
	
}
