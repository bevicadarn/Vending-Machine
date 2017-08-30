package TextFileCreate;

public class Person {
	private String name;
	
	public Person() {
		// TODO Auto-generated constructor stub
		name = "Unknown";
	}

	
	public Person(String theName) {
		name = theName;
	}
	
	
	public String getName() {
		return name;
	}
	
	public String changeName(String newName) {
		name = newName;
		return name;
	}
}
