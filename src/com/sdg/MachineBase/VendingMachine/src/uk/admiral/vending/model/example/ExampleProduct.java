package uk.admiral.vending.model.example;

import uk.admiral.vending.model.vendingmachine.stockmanager.IVendable;

/**
 * An example IVendable, this can be used for testing purposes.
 * @author PLUNKED
 */
public class ExampleProduct implements IVendable {

	private String Description;
	
	public ExampleProduct(String desc){
		Description = desc;
		
	}


	public String getDescription() {
		return Description;
	}
	
	
}
