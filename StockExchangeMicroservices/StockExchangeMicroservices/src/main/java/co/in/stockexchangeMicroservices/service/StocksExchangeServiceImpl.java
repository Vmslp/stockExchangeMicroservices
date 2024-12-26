package co.in.stockexchangeMicroservices.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.in.stockexchangeMicroservices.entity.StocksExchange;
import co.in.stockexchangeMicroservices.exception.InvalidStockExchangeException;
import co.in.stockexchangeMicroservices.exception.StockExchangeNotFoundException;
import co.in.stockexchangeMicroservices.repository.StocksExchangeRepository;

@Service
public class StocksExchangeServiceImpl implements IStocksExchangeService {

	@Autowired
	private StocksExchangeRepository stocksExchangeRepository;

	@Override
	public List<StocksExchange> getAllStockExchanges() {
		return stocksExchangeRepository.findAll();
	}

	@Override
	public Optional<StocksExchange> getStockExchangeById(int exchangeId) {
		Optional<StocksExchange> stockExchange = stocksExchangeRepository.findById(exchangeId);
		if (stockExchange.isEmpty()) {
			throw new StockExchangeNotFoundException("Stock exchange with id " + exchangeId + " not found");
		}
		return stockExchange;
	}

	@Override
	public StocksExchange updateStockExchange(int exchangeId, StocksExchange stockExchangeDetails) {
		Optional<StocksExchange> existingStockExchangeOpt = stocksExchangeRepository.findById(exchangeId);
		if (existingStockExchangeOpt.isEmpty()) {
			throw new StockExchangeNotFoundException("Stock exchange with id " + exchangeId + " not found");
		}

		StocksExchange existingStockExchange = existingStockExchangeOpt.get();
		existingStockExchange.setExchangeName(stockExchangeDetails.getExchangeName());
		existingStockExchange.setDescription(stockExchangeDetails.getDescription());
		return stocksExchangeRepository.save(existingStockExchange);
	}

	@Override
	public void deleteStockExchangeById(int exchangeId) {
		if (!stocksExchangeRepository.existsById(exchangeId)) {
			throw new StockExchangeNotFoundException("Stock exchange with id " + exchangeId + " not found");
		}
		stocksExchangeRepository.deleteById(exchangeId);
	}

	@Override
	public StocksExchange createStockExchange(StocksExchange stockExchange) {
		if (stockExchange.getExchangeName() == null || stockExchange.getExchangeName().isEmpty()) {
			throw new InvalidStockExchangeException("Stock exchange name cannot be empty");
		}
		return stocksExchangeRepository.save(stockExchange);
	}
}
