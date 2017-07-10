package com.sdg.MachineBase;

public class ProductSlot {
	private int capacity;
	private int stockLevel;
	
	
	public ProductSlot() {
		// TODO Auto-generated constructor stub
	}

	
	
	
	public void setSlotPrice(){
		
	}
	
	
	public void addStock(int amount) throws VendingMachineException {
		if ((stockLevel + amount) < capacity) {
			stockLevel =  stockLevel + amount;
		} else {
			throw new VendingMachineException("Slot is already full");
			
		}
			
			
	}
	
	
}
