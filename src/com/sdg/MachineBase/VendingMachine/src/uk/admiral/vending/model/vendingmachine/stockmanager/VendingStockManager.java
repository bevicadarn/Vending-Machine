package uk.admiral.vending.model.vendingmachine.stockmanager;

import java.util.ArrayList;

import uk.admiral.vending.model.vendingmachine.VendingMachineException;

/**
 * Class for managing stock levels within a Vending machine
 * 
 * @author PLUNKED
 */
public class VendingStockManager {

	ArrayList<ArrayList<VendingMachineStockPosition>> _StockLevels;
	int MaxX;
	int MaxY;
	
	//# constructs the stock manager with given width and height
	public VendingStockManager(int StockWidth, int stockHeight){
		
		_StockLevels = new ArrayList<ArrayList<VendingMachineStockPosition>>();
		MaxX = StockWidth;
		MaxY = stockHeight;
		
		for(int i = 0; i < StockWidth; i++){
			_StockLevels.add(new ArrayList<VendingMachineStockPosition>());
			
			for(int l = 0; l < StockWidth; l++){
				_StockLevels.get(i).add(new VendingMachineStockPosition(i, l));
			}
		}
		
	}
	
	//# re-stocks the product at the specified location
	public void restockProductInPosition(int ProductX, int ProductY, IVendable Product, int AmountToStock, double Price) throws VendingMachineException{	
		if(ProductX > MaxX || ProductY > MaxY){
			throw new VendingMachineException("You cannot stock into this position - Max (" + MaxX + "," + MaxY + ")" );
		}
		
		if(ProductX < 0 || ProductY < 0){
			throw new VendingMachineException("You cannot stock into this position - Min (0, 0)" );
		}
		
		_StockLevels.get(ProductX).get(ProductY).restockProduct(Product, AmountToStock, Price);
	}
	
	//# Attempts to retrieve the price of the product stored in the specified position
	public double getPriceOfProductInPosition(int ProductX, int ProductY) throws VendingMachineException{
		return _StockLevels.get(ProductX).get(ProductY).getPriceOfStock();
	}
	
	//# Attempts to retrieve the product stored in the specified position
	public IVendable attemptToVendProductInPosition(int ProductX, int ProductY) throws VendingMachineException{
		return _StockLevels.get(ProductX).get(ProductY).attemptToVend();
	}
	
	
}
