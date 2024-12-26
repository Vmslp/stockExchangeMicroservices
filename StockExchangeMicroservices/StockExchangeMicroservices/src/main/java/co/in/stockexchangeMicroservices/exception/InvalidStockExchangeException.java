package co.in.stockexchangeMicroservices.exception;

public class InvalidStockExchangeException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidStockExchangeException(String message) {
        super(message);
    }
}