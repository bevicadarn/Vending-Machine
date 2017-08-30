package uk.admiral.vending.model.vendingmachine;

/**
 * 
 * Vending Machine class intended to be used as a custom exception within the
 * Vending machine
 * 
 * @author PLUNKED
 */
@SuppressWarnings("serial")
public class VendingMachineException extends Exception {

	public VendingMachineException(String Message) {
		super(Message);

	}

}
