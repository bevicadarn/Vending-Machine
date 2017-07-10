package com.sdg.MachineBase;

public class CoinCase {

	// array of number of each coins and potential valkues
	private int [] noOfCoins = new int[8];
	private double [] values = new double[]{0.01, 0.02, 0.05, 0.1, 0.2, 0.5, 1.0, 2.0};
	
	private int onePencePos = 1;
	private int twoPencePos = 2;
	private int fivePencePos = 3;
	private int tenPencePos = 4;
	private int twentyPencePos = 5;
	private int fiftyPencePos = 6;
	private int onePoundPos = 7;
	private int twoPoundPos = 8; 
	
	public CoinCase() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public double getTotalBanked() {
		double total = 0.00;
		for (int i = 0; i < values.length; i++) {
			total += noOfCoins[i] * values[i];
		}
		return total;
	}
}
