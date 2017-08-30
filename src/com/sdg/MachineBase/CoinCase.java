package com.sdg.MachineBase;

import java.util.ArrayList;
import java.util.Arrays;

public class CoinCase {

	// array of number of each coins and potential valkues
	private int [] noOfCoins = new int[CoinType.values().length];

	
	ArrayList<String> coinNames = new ArrayList<String>();

	
	public CoinCase() {
		// TODO Auto-generated constructor stub
	}
	
	
	public void addCoin(Coin newCoin) {
		for (int i = 0; i < CoinType.values().length; i++) {

			if (newCoin.getValue() == CoinType.values()[i].getEnumValue()) {
				noOfCoins[i] ++;
				
			}
			System.out.println(" noOfCoins  " + i + " is " + noOfCoins[i]);
		}
	}
	
	public double getTotalBanked() {
		double total = 0.00;
		
		
		for (int i = 0; i < values.length; i++) {
			total += noOfCoins[i] * values[i];
		}
		return total;
	}

}
