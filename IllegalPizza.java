public class IllegalPizza extends Exception{

	private static final long serialVersionUID = -5935590159508055457L;

	// Supplies a default message.
	public IllegalPizza() {
		super("Illegal attributes for pizza object");
	}
	
	/**
	 * @param message Supplies message from the objects
	 */
	public IllegalPizza(String message) {
		super(message);
	}
}
