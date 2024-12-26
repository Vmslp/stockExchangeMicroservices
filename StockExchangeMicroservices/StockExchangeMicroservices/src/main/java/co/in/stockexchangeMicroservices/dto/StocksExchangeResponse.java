package co.in.stockexchangeMicroservices.dto;

public class StocksExchangeResponse {

	private int exchangeId;

	private String exchangeName;
	private String description;

	private StocksResponse stocksResponse;

	public int getExchangeId() {
		return exchangeId;
	}

	public void setExchangeId(int exchangeId) {
		this.exchangeId = exchangeId;
	}

	public String getExchangeName() {
		return exchangeName;
	}

	public void setExchangeName(String exchangeName) {
		this.exchangeName = exchangeName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public StocksResponse getStocksResponse() {
		return stocksResponse;
	}

	public void setStocksResponse(StocksResponse stocksResponse) {
		this.stocksResponse = stocksResponse;
	}

	public StocksExchangeResponse(int exchangeId, String exchangeName, String description,
			StocksResponse stocksResponse) {
		super();
		this.exchangeId = exchangeId;
		this.exchangeName = exchangeName;
		this.description = description;
		this.stocksResponse = stocksResponse;
	}

	public StocksExchangeResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "StocksExchangeResponse [exchangeId=" + exchangeId + ", exchangeName=" + exchangeName + ", description="
				+ description + ", stocksResponse=" + stocksResponse + "]";
	}

}