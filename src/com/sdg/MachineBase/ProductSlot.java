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
		if (stockLevel == capacity) {
			throw new VendingMachineException("Slot is already full");
		} else {
			if ((stockLevel + amount) < capacity) {
				stockLevel =  stockLevel + amount;
			} else {
				int amountAdded = capacity - stockLevel;
				
				stockLevel = capacity;
				
				
				throw new VendingMachineException("You are trying to add more stock than the slot can take. Only " + amountAdded + " items have been added");
				
			}
		}	
			
	}
	
	
}
