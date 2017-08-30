package uk.admiral.vending.model.vendingmachine.coinmanager;

/**
 * A class to represent a coin. 
 * @author PLUNKED
 */
public class Coin {

	private double Value = 0;
	private CoinTypes thisType;
	
	public enum CoinTypes {
		ONE,
		TWO,
		FIVE,
		TEN,
		TWENTY,
		FIFTY,
		POUND,
		TWO_POUND	
	}

	public Coin(CoinTypes coinType){
		thisType = coinType;
				
		switch (coinType) {
			case ONE:
				Value = 0.1;
				break;
			case TWO:
				Value = 0.2;
				break;
			case FIVE:
				Value = 0.5;
				break;
			case TEN:
				Value = 0.10;
				break;
			case TWENTY:
				Value = 0.20;
				break;
			case FIFTY:
				Value = 0.50;
				break;
			case POUND:
				Value = 1.00;
				break;
			case TWO_POUND:
				Value = 2.00;
				break;
			default:
				break;
		}
	}
		
	public CoinTypes getType(){
		return thisType;
	}
	
	public double getValue() {
		return Value;
	}
	
	
}
