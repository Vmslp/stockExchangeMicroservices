package co.in.stockexchangeMicroservices.exception;

public class StockExchangeNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StockExchangeNotFoundException(String message) {
		super(message);
	}
}
