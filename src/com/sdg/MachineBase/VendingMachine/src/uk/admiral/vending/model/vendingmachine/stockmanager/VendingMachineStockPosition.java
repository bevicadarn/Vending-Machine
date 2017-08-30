package uk.admiral.vending.model.vendingmachine.stockmanager;

import uk.admiral.vending.model.vendingmachine.VendingMachineException;

public class VendingMachineStockPosition {


	private int xPos;
	private int yPos;
	private IVendable ProductToVend = null;
	private double PriceOfStock = -10;
	private int StockLevel = 0;
	
	public VendingMachineStockPosition(int xPosition, int yPosition){
		xPos = xPosition;
		yPos = yPosition;
	}
			
	//# attempt to vend a product from this location
	public IVendable attemptToVend() throws VendingMachineException{
		if(StockLevel > 0 ) {
			StockLevel--;
			//# if the stock level reaches 0 - reset this stock position
			IVendable Vending = ProductToVend;
			
			if(StockLevel == 0){
				PriceOfStock = -10;
				ProductToVend = null;
			}
			return Vending;
		} else {
			throw new VendingMachineException("There is no stock in this vending position.");
		}
	}

	//# gets the price of the stock in this position
	public double getPriceOfStock() throws VendingMachineException{
		if(PriceOfStock != -10){
			return PriceOfStock;
		} else {
			throw new VendingMachineException("There is no stock loaded into this position.");
		}
		
	}
	
	//# will restock the machine 
	public void restockProduct(IVendable Product, int AmountToStock, double Price){
		ProductToVend = Product;
		StockLevel = AmountToStock;
		PriceOfStock = Price;
		
	}
	
}
