import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class SearchMap {

	public static void main(String[] args) {
		
		if(args.length != 2) {
			System.out.println("Invalid arguments");
			return;
		}
		
		String infile = args[0];
		
		String outfile = args[1];
		
		String line = null;
		
		try {
            FileReader fr = new FileReader(infile);
            BufferedReader br = new BufferedReader(fr);
            
            String origin = br.readLine();
            
            String source, dest;
            double cost;
            
            while((line = br.readLine()) != null) {
                System.out.println(line);
                                
                String[] splitted_line = line.split(" ");
                
                source = splitted_line[0];
                dest = splitted_line[1];
                cost = Double.parseDouble(splitted_line[2]);
                
                
                
            }   
            
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
