package TextFileCreate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;


public class Flight implements Comparable<Flight>, Iterable<Person>, Serializable {
	public Integer flightNumber;
	static final int MAX_FAA_SEATS = 550;
	public int passengers, seats = 150, firstClassSeats;
	public int maxCarryOns, totalCarryOns, totalCheckedBags;
	private int flightTime; // mins past midnight
	public Character flightClass;

	private boolean[] isSeatAvailable = new boolean[seats];
	private CrewMember[] crew;
	private Passenger[] roster;
	
	
	// Initialization block
	{
		for(int i = 0; i < seats; i++)
		isSeatAvailable[i] = true;
	}
	
	// Blank constructor
	public Flight(){
		setMaxCarryOns();
	}
	
	// seat constructor
	public Flight(int thisNumberSeats, int firstClassSeats) {
		this.seats = thisNumberSeats;
		this.firstClassSeats = firstClassSeats;
		setMaxCarryOns();
	}
	
	// Flight Class constructor
	public Flight(char flightClass) {
		this.flightClass = flightClass;
	}
	
	// Flight Number constructor
	public Flight(int flightNumber) {
		this.flightNumber = flightNumber;
	}
	
	// Combination constructor
	public Flight (Flight flightOne, Flight flightTwo){
		this.seats = flightOne.seats + flightTwo.seats;
		this.passengers = flightOne.passengers + flightTwo.passengers;	
		System.out.println(" Seats 1 " + flightOne.seats);
		System.out.println(" Seats 2 " + flightTwo.seats);
		setMaxCarryOns();
	}
	
	// Accessors
	public int getpassengers() {return passengers;}
	public int getseats() {return seats;}
	public int getfirstClassSeats() {return firstClassSeats;}
	public char getflightClass() {return flightClass;}
	public int getMaxCarryOns() {return maxCarryOns;}
	
	// Direct Mutators
	public void setSeats(int seats){
		if (seats <= MAX_FAA_SEATS)
			this.seats = seats;
		else
			System.out.println("Above Legal Limit");
	}
		
	public void setfirstClassSeats(int firstClassSeats){
		if (firstClassSeats <= MAX_FAA_SEATS)
			this.firstClassSeats = (this.seats / 2);
		else
			System.out.println("Not enough seats");
	}
	
	public void setflightClass(char flightClass){this.flightClass = flightClass;}
	
	
	public void setflightTime(int theTime){
		flightTime = theTime;
	}

	

	// check seating
	private boolean hasSeatingLeft(){
		return passengers < seats;
	}
	
	private boolean hasSeatingLeft(int count){
		return (passengers + count) < seats;
	}
	
	//set carry on max
	private void setMaxCarryOns(){
		maxCarryOns = seats * 2;
	}
	
	// add passenger method
	public void addPassengers() {
		if (hasSeatingLeft()) {
			this.passengers ++;
		} else { 
			handleTooMany();
		}
	}
	
	public void addPassenger(String name) {
		Passenger newPassenger = new Passenger(name);
		roster = extendPassengerArray(roster, newPassenger);
	}
	
	public void addCrew(String name) {
		CrewMember newCrew = new CrewMember(name);

	}
	

	
	
	public void addPassengers(int bags) {
		if (hasSeatingLeft()) {
			addPassengers();
			this.totalCheckedBags += bags;
		} else { 
			handleTooMany();
		}
	}
	
	public void addPassengers( ArrayList<String> passengerList) {
		if (hasSeatingLeft(passengerList.size())) {
			this.passengers += passengerList.size();
		} else { 
			handleTooMany();
		}
	}
	
	public void addPassengers(String fileName) throws IOException {
		BufferedReader reader = null;
		
		reader = new BufferedReader(new FileReader(fileName));
		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(" ");
				passengers += Integer.valueOf(parts[0]);
			}
		} finally {
			if (reader != null)
				reader.close();
		}
	}

	// 
	private void handleTooMany() {
		System.out.println("Flight is full!");	
		}	
	
	public boolean hasRoom(){
		int total = this.passengers + this.passengers;
		return total <= seats;
	}
	
	@Override
	public String toString() {
		if(flightNumber != null)
			return "Flight #" + flightNumber;
		else if (flightClass != null)
			return "Flight Class " + flightClass;
		else
			return "identity not set";
	}
	
	private CrewMember[] extendCrewArray(CrewMember [] currCrew, CrewMember newCrew) {
		if (currCrew == null) {
			CrewMember [] tempArray = new CrewMember [1];
			tempArray[0] = newCrew;
			return tempArray;
		} else {
			int counter = currCrew.length;
			System.out.println("counter = " + counter);	
			CrewMember [] tempArray = new CrewMember [counter + 1];
			for(int i = 1; i < counter; i++) {
				tempArray[i] = currCrew[i];
			}
			tempArray[counter] = newCrew;
			return tempArray;
		}
	}

	
	private Passenger[] extendPassengerArray(Passenger [] currPassengers, Passenger newPassenger) {

		if (currPassengers == null) {
			Passenger [] tempArray = new Passenger [1];
			tempArray[0] = newPassenger;
			return tempArray;
		} else {
			int counter = currPassengers.length;
			System.out.println("counter = " + counter);	
			Passenger [] tempArray = new Passenger [counter + 1];
			for(int i = 1; i < counter; i++) {
				tempArray[i] = currPassengers[i];
			}
			tempArray[counter] = newPassenger;
			return tempArray;
		}		
	}
	
	public int compareTo(Flight o) {
		Flight f = (Flight) o;
		return flightTime - f.flightTime;
	}
	
	public Iterator<Person> iterator() {
		// Use an anonymous class, a sub-type of an inner class
		return new Iterator<Person>() {
			private int index = 0;
			
			public boolean hasNext() {
				return index < (crew.length + roster.length);
			}
			
			public Person next(){
				Person p = (index < crew.length) ? crew[index] : roster[index - crew.length];
				index++;
				return p;
			}

			@Override
			public void remove() {
				// Blank implementation	
			}			
			
		};
	}
	
	
		
	
}
