package uk.admiral.vending.model.vendingmachine;


import java.text.DecimalFormat;
import java.util.ArrayList;

import uk.admiral.vending.model.vendingmachine.coinmanager.Coin;
import uk.admiral.vending.model.vendingmachine.coinmanager.VendingCoinManager;
import uk.admiral.vending.model.vendingmachine.stockmanager.IVendable;
import uk.admiral.vending.model.vendingmachine.stockmanager.VendingStockManager;

/**
 * A class to represent and simulate the functionality of a Vending machine.
 * 
 * @author PLUNKED
 */
public class VendingMachine {
	

	private VendingCoinManager _CoinManager; 
	private VendingStockManager _StockManager; 
	private static DecimalFormat df2 = new DecimalFormat("0.00");
	private static ArrayList<Coin> _CoinsInChangeTray = new ArrayList<Coin>();

	public VendingMachine(int stockWidth, int StockHeight){
		_CoinManager = new VendingCoinManager();
		_StockManager = new VendingStockManager(stockWidth, StockHeight);
		System.out.println("-- Creating new Vending Machine (" + stockWidth +","+ StockHeight + ")");
	}
	
	/**
	 * Allows the customer to insert a coin into the vending machine
	 * 
	 * @param aCoin
	 */
	public void insertCoin(Coin aCoin){
		_CoinManager.insertCoin(aCoin);
		System.out.println("-- Inserting coin £" + df2.format(aCoin.getValue()) + " (Total £" + df2.format(_CoinManager.getValueOfInsertedCoins()) + ")");
	}
	
	/**
	 * Returns any coins inserted so far to the customer 
	 * @return
	 */
	public void returnCoinsNoPurchase(){
		System.out.println("-- Returning coins to the change tray without purchase.");
		_CoinsInChangeTray.addAll(_CoinManager.returnCoinsWithoutPurchase());
	}
	
	/**
	 * Allows the owner to re-stock the machines change
	 * 
	 * @param Type - The Type of coin to be restocked
	 * @param Amount - The number of coins to stock
	 */
	public void restockChange(Coin.CoinTypes Type, int Amount){		
		System.out.println("-- Restocking change (" + Type + ")" );
		_CoinManager.addChange(Type, Amount);
	}
	
	/**
	 *  Allows the owner to re-stock the machines products
	 * @param stockXPosition - the XPosition
	 * @param StockYPosition
	 * @param Product
	 * @param StockAmount
	 * @param Price
	 * @throws VendingMachineException 
	 */
	public void restockProductAtLocation(int stockXPosition, int StockYPosition, IVendable Product, int StockAmount, double Price) throws VendingMachineException{
		System.out.println("-- Restocking product '" + Product.getDescription()+  "' into position (" + stockXPosition + ", " + StockYPosition  +") cost £" + df2.format(Price) + " -- " + StockAmount + " items added.");
		_StockManager.restockProductInPosition(stockXPosition, StockYPosition, Product, StockAmount, Price);
	}
	
	/**
	 * 
	 * @param stockXPosition 
	 * @param StockYPosition
	 * @return The Product in the 
	 * @throws VendingMachineException
	 */
	public IVendable attemptToVendProduct(int stockXPosition, int StockYPosition ) throws VendingMachineException{
		System.out.println("-- Attempting to vend product at position (" +stockXPosition +", "+ StockYPosition + ")" );
		
		double price = _StockManager.getPriceOfProductInPosition(stockXPosition, StockYPosition);
		if(_CoinManager.CanAffordProduct(price)){
			
			//# calculate the change that will be given 
			ArrayList<Coin> Change = _CoinManager.returnChange(price);
			
			double ChangeValue = 0.00;
			for (Coin coin : Change) {
				ChangeValue+= coin.getValue();
			}
			
			IVendable item = _StockManager.attemptToVendProductInPosition(stockXPosition, StockYPosition);
			
			if(item != null){
				//# add the change to the change tray
				_CoinsInChangeTray.addAll(Change);
				
				double coinValue = 0.00;
				for (Coin coin : _CoinsInChangeTray) {
					coinValue += coin.getValue();
				}
				
				System.out.println("-- Successfully vended : '" + item.getDescription() + "'");
				System.out.println("-- Returning £" + df2.format(ChangeValue) +  " to the change tray. (" + df2.format(coinValue) + " in tray)");
				
				return item;
			} else {
				//# throw a new exception detailing that the vending position is empty.
				throw new VendingMachineException("This position is now empty!");
			}
			
		} else {
			//# throw a new exception detailing that we cannot afford the item
			throw new VendingMachineException("You cannot afford this product - price of product(£" + df2.format(_StockManager.getPriceOfProductInPosition(stockXPosition, StockYPosition))
																					  + ") Amount inserted (£" + df2.format(_CoinManager.getValueOfInsertedCoins()) + ")");
		}
		
		
	}

	/**
	 * Allows the customer to retrieve their change from the coin tray
	 * @return
	 */
	public ArrayList<Coin> retrieveCoinsFromChangeTray(){
		System.out.println("-- Retrieving change from the change tray");	
		
		ArrayList<Coin> _CoinsToReturn = _CoinsInChangeTray;
		_CoinsToReturn = new ArrayList<Coin>();
		return _CoinsToReturn;
	}
	
}
