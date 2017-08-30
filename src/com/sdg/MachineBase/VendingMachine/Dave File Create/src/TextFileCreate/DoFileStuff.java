package TextFileCreate;


public class DoFileStuff {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TextFileReader myReader = new TextFileReader();
		myReader.readMyFile(args);
		
		TextFileWriter myWriter = new TextFileWriter();
		
		String[] filesOut = new String[2];
		filesOut[0] = args[0];
		filesOut[1] = "C:\\sg temp\\DummyFileDump\\CopiedFile.txt";
		myWriter.writeFile(filesOut);
		System.out.println("");
		System.out.println("");
		
		Flight FlightOne = new Flight(100, 99); 
		Flight FlightTwo = new Flight(11, 35); 
		
		
		String pathOne = "C:\\sg temp\\DummyFileDump\\someFlight";
		String pathTwo = "C:\\sg temp\\DummyFileDump\\otherFlight";
		
		
		SerializeThis serializerThing = new SerializeThis();
		
		serializerThing.doSerializing(FlightOne, pathOne);
		serializerThing.doSerializing(FlightTwo, pathTwo);
		serializerThing.doDeserializing(pathOne);
		serializerThing.doDeserializing(pathTwo);
		

	}

}
