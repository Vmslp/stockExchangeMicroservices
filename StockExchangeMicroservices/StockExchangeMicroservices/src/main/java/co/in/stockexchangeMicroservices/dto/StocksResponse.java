package co.in.stockexchangeMicroservices.dto;

public class StocksResponse {

	private int stockId;
	private String companyName;
	private int companyPrice;
	
	private StocksExchangeResponse stocksExchangeResponse;

	public int getStockId() {
		return stockId;
	}

	public void setStockId(int stockId) {
		this.stockId = stockId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public int getCompanyPrice() {
		return companyPrice;
	}

	public void setCompanyPrice(int companyPrice) {
		this.companyPrice = companyPrice;
	}

	public StocksExchangeResponse getStocksExchangeResponse() {
		return stocksExchangeResponse;
	}

	public void setStocksExchangeResponse(StocksExchangeResponse stocksExchangeResponse) {
		this.stocksExchangeResponse = stocksExchangeResponse;
	}

	public StocksResponse(int stockId, String companyName, int companyPrice,
			StocksExchangeResponse stocksExchangeResponse) {
		super();
		this.stockId = stockId;
		this.companyName = companyName;
		this.companyPrice = companyPrice;
		this.stocksExchangeResponse = stocksExchangeResponse;
	}

	public StocksResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "StocksResponse [stockId=" + stockId + ", companyName=" + companyName + ", companyPrice=" + companyPrice
				+ ", stocksExchangeResponse=" + stocksExchangeResponse + "]";
	}

}
