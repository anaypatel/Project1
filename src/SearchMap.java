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
            
            char origin = br.readLine().charAt(0);
            
            
            while((line = br.readLine()) != null) {
                System.out.println(line);
                                
                
                
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
