package com.sdg.MachineBase;

public class VendingMachineException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public VendingMachineException(String message) {
        super(message);
    }

    public VendingMachineException(String message, Throwable throwable) {
        super(message, throwable);
    }
	
	
}
