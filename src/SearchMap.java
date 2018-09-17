import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
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
		
		String origin = null;
		
		FlightGraph flight_graph = null;
		
		// Parse the infile using FileReader/BufferedReader
		String line = null;
		try {
            FileReader fr = new FileReader(infile);
            BufferedReader br = new BufferedReader(fr);
            
            // Record the first line as the origin
            origin = br.readLine();
            
            // Source, destination, and cost to be recorded on every subsequent line
            String source, dest;
            double cost;
            
            // Create a new graph of flights and put the origin in the cityMap
            flight_graph = new FlightGraph(origin);
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
            
            flight_graph.path(flight_graph.cityMap.get(origin));

            // Close the BufferedReader
            br.close();         
        }
        catch(FileNotFoundException ex) {
            ex.printStackTrace();                
        }
        catch(IOException ex) {
            ex.printStackTrace();                  
        }	
		
		try {
			FileWriter fw = new FileWriter(outfile);
			
			String output = String.format("%5s%25s%20s", "Destination", "Flight Route From " + origin, "Total Cost");
			output += "\n";
								
			for(String k : flight_graph.paths.keySet()) {
				if(!flight_graph.paths.get(k).equals("origin")) {
					output += String.format("%5s%25s%20s", k, flight_graph.path_finder(k), flight_graph.path_cost(k));
					output += "\n";
				}
			}
			
			fw.write(output);
			fw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
}
