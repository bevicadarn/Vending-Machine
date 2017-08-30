package uk.admiral.vending.model.vendingmachine.coinmanager;

import java.util.ArrayList;
import java.util.HashMap;

import uk.admiral.vending.model.vendingmachine.VendingMachineException;
import uk.admiral.vending.model.vendingmachine.coinmanager.Coin.CoinTypes;

/**
 * Class for managing the coin stock levels within a vending machine
 * 
 * @author PLUNKED
 */
public class VendingCoinManager {

	HashMap<Coin.CoinTypes, Integer> _CoinStock = new HashMap<Coin.CoinTypes, Integer>();
	ArrayList<Coin> _currentlyInsertedCoins = new ArrayList<Coin>();
		
	//# adds change to the coin manager
	public void addChange(Coin.CoinTypes Type, Integer Amount){
		if(!_CoinStock.containsKey(Type)) {
			_CoinStock.put(Type, Amount);
		} else {
			_CoinStock.put(Type, _CoinStock.get(Type) + Amount);	
		}
	}
	
	//# Loops through the inserted coins to determine whether or not the product can be afforded.
	public boolean CanAffordProduct(double Price){
		double CoinValue = 0;
		
		for (Coin coin : _currentlyInsertedCoins) {
			CoinValue += coin.getValue();
		}
		
		return (CoinValue >= Price);
	}
		
	//# gets the value of the currently inserted coins
	public double getValueOfInsertedCoins(){
		
		double CoinValue = 0;
		
		for (Coin coin : _currentlyInsertedCoins) {
			CoinValue += coin.getValue();
		}
		
		return CoinValue;
	}
	
	//# calculates the change due based on the currently inserted coins and the price and provides coins from the coin stock
	public ArrayList<Coin> returnChange(double Price) throws VendingMachineException{
		
		ArrayList<Coin> Change = new ArrayList<Coin>();
		double changeDue = getValueOfInsertedCoins() - Price;
		
		if(_CoinStock.get(CoinTypes.TWO_POUND) != null){
			while(changeDue >= 2.00 && _CoinStock.get(CoinTypes.TWO_POUND) > 0){
				Change.add(new Coin(CoinTypes.TWO_POUND));
				_CoinStock.put(CoinTypes.TWO_POUND, _CoinStock.get(CoinTypes.TWO_POUND) - 1);
				changeDue -= 2.00;
			}
		}
		
		if(_CoinStock.get(CoinTypes.POUND) != null){
			while(changeDue >= 1.00 && _CoinStock.get(CoinTypes.POUND) > 0){
				Change.add(new Coin(CoinTypes.POUND));
				_CoinStock.put(CoinTypes.POUND, _CoinStock.get(CoinTypes.POUND) - 1);
				changeDue -= 1.00;
			}
		}
		
		if(_CoinStock.get(CoinTypes.FIFTY) != null){
			while(changeDue >= 0.50 && _CoinStock.get(CoinTypes.FIFTY) > 0){
				Change.add(new Coin(CoinTypes.FIFTY));
				_CoinStock.put(CoinTypes.FIFTY, _CoinStock.get(CoinTypes.FIFTY) - 1);
				changeDue = changeDue - 0.50;
			}
		}
		
		if(_CoinStock.get(CoinTypes.TWENTY) != null){
			while(changeDue >= 0.20 && _CoinStock.get(CoinTypes.TWENTY) > 0){
				Change.add(new Coin(CoinTypes.TWENTY));
				_CoinStock.put(CoinTypes.TWENTY, _CoinStock.get(CoinTypes.TWENTY) - 1);
				changeDue -= 0.20;
			}
		}
		
		if(_CoinStock.get(CoinTypes.TEN) != null){
			while(changeDue >= 0.10 && _CoinStock.get(CoinTypes.TEN) > 0){
				Change.add(new Coin(CoinTypes.TEN));
				_CoinStock.put(CoinTypes.TEN, _CoinStock.get(CoinTypes.TEN) - 1);
				changeDue -= 0.10;
			}
		}
		
		if(_CoinStock.get(CoinTypes.TWO) != null){
			while(changeDue >= 0.02 && _CoinStock.get(CoinTypes.TWO) > 0){
				Change.add(new Coin(CoinTypes.TWO));
				_CoinStock.put(CoinTypes.TWO, _CoinStock.get(CoinTypes.TWO) - 1);
				changeDue -= 0.02;
			}
		}

		if(_CoinStock.get(CoinTypes.ONE) != null){
			while(changeDue >= 0.01 && _CoinStock.get(CoinTypes.ONE) > 0){
				Change.add(new Coin(CoinTypes.ONE));
				_CoinStock.put(CoinTypes.ONE, _CoinStock.get(CoinTypes.ONE) - 1);
				changeDue -= 0.01;
			}
		}
		
		if(Math.round(changeDue) > 0.00){
			
			throw new VendingMachineException("Not Enough Change to Vend!");
		}
		
		_currentlyInsertedCoins = new ArrayList<Coin>();
		return Change;
	}
	
	//# allows the customer to insert a coin
	public void insertCoin(Coin aCoin){
		_currentlyInsertedCoins.add(aCoin);
	}
	
	//# returns the coins that have been inserted so far
	public ArrayList<Coin> returnCoinsWithoutPurchase(){
		ArrayList<Coin> currentCoins = _currentlyInsertedCoins;
		_currentlyInsertedCoins = new ArrayList<Coin>();
		
		return currentCoins;
	}
	
}
