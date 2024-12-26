package co.in.stockexchangeMicroservices.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "stocksexchange")
public class StocksExchange {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int exchangeId;
	
	private String exchangeName;
	private String description;

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

	public StocksExchange(int exchangeId, String exchangeName, String description) {
		super();
		this.exchangeId = exchangeId;
		this.exchangeName = exchangeName;
		this.description = description;
	}

	public StocksExchange() {
		super();
		
	}

	@Override
	public String toString() {
		return "StocksExchange [exchangeId=" + exchangeId + ", exchangeName=" + exchangeName + ", description="
				+ description + "]";
	}

}
