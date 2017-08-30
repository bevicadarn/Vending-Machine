package TextFileCreate;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeThis {
	
	public static void doSerializing(Object anObject, String filePath) {
		
		try(ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream(filePath))){
			outStream.writeObject(anObject);
			
		} catch(FileNotFoundException fnfe) {
			System.err.printf("Cannot create file called that");
		} catch (IOException ioe) {
			System.err.printf("An IO exception happened");
		} 
		
		
		
				
	}
	
	
	
	public static void doDeserializing(String filePath) {
		
		try(ObjectInputStream inStream = new ObjectInputStream(new FileInputStream(filePath))){
			Object obIn = inStream.readObject();
			
			if (obIn != null && obIn instanceof Flight) {
				Flight thisFlight = (Flight) obIn;
				System.out.println("First class seats: " + thisFlight.getfirstClassSeats());
			}
			
		} catch(FileNotFoundException fnfe) {
			System.err.printf("Cannot create file called that");
		} catch (IOException ioe) {
			System.err.printf("An IO exception happened");
		} catch (ClassNotFoundException cnfe) {
			System.err.printf("Class not recognised");
		}
				
	}
	

}
