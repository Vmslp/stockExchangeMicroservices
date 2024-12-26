package co.in.stockexchangeMicroservices.service;

import java.util.List;
import java.util.Optional;

import co.in.stockexchangeMicroservices.entity.StocksExchange;

public interface IStocksExchangeService {

	StocksExchange createStockExchange(StocksExchange stockExchange);

	List<StocksExchange> getAllStockExchanges();

	Optional<StocksExchange> getStockExchangeById(int exchangeId);

	StocksExchange updateStockExchange(int exchangeId, StocksExchange stockExchangeDetails);

	void deleteStockExchangeById(int exchangeId);

}
