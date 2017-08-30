package TextFileCreate;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;





public class TextFileReader {

	public void readMyFile(String[] files) {
		
		if (files.length == 0) {
			
			System.exit(-1);
		}
		
		
		
		
		
		for (String file: files) {
			try (FileReader inputFile = new FileReader(file)) {
				int chars = 0;
				
				
				while( (chars = inputFile.read()) != -1 ) {
					System.out.print((char)chars);
					
				}
				
				
				
				
			} catch  (FileNotFoundException notFound){
				
				System.err.printf("Cannot open the file %s ", file);
			} catch(IOException ioe) {
				
				System.err.printf("Error when processing file %s ", file);
			}
			
			
		}

	
	
	
	
	
	
	
	
	
	
	
	
	
	}

}
