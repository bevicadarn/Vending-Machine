package TextFileCreate;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TextFileWriter {

	public void writeFile(String[] files) {
		if (files.length != 2) {
			System.err.printf("First parameter must be an array of SourceFile DestFile");
			System.exit(-1);
		}
		

		
		String source = files[0];
		String destination = files[1];
		
		try (BufferedReader inputFile = new BufferedReader(new FileReader(source)); 
			BufferedWriter outputFile = new BufferedWriter(new FileWriter(destination))) {
					
					
			int chars = 0;
			
			
			while((chars = inputFile.read()) != -1) {
				
				outputFile.write((char) chars);
			}
						
					
		} catch  (FileNotFoundException notFound){
			
			System.err.printf("Cannot open the file %s ", notFound.getMessage());
		} catch(IOException ioe) {
			
			System.err.printf("Error when processing file, getting out ");
		}
		


		
	}
	
	
	

}
