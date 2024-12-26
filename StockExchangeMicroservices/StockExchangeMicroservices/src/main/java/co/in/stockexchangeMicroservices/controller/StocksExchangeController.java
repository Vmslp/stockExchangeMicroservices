package co.in.stockexchangeMicroservices.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.in.stockexchangeMicroservices.entity.StocksExchange;
import co.in.stockexchangeMicroservices.service.IStocksExchangeService;

@RestController
@RequestMapping("${api.stock-exchange.baseurl-path}")
public class StocksExchangeController {

	@Autowired
	private IStocksExchangeService stockExchangeService;

	@PostMapping
	public ResponseEntity<StocksExchange> createStockExchange(@RequestBody StocksExchange stockExchange) {
		StocksExchange createdStockExchange = stockExchangeService.createStockExchange(stockExchange);
		return new ResponseEntity<>(createdStockExchange, HttpStatus.CREATED);
	}

	@GetMapping("${api.stock-exchange.get-all-path}")
	public ResponseEntity<List<StocksExchange>> getAllStockExchanges() {
		List<StocksExchange> stockExchanges = stockExchangeService.getAllStockExchanges();
		return new ResponseEntity<>(stockExchanges, HttpStatus.OK);
	}

	@GetMapping("${api.stock-exchange.get-by-id-path}")
	public ResponseEntity<StocksExchange> getStockExchangeById(@PathVariable int exchangeId) {
		Optional<StocksExchange> stockExchangeOpt = stockExchangeService.getStockExchangeById(exchangeId);
		return stockExchangeOpt.map(stockExchange -> new ResponseEntity<>(stockExchange, HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PutMapping("${api.stock-exchange.update-path}")
	public ResponseEntity<StocksExchange> updateStockExchange(@PathVariable int exchangeId,
			@RequestBody StocksExchange stockExchangeDetails) {
		StocksExchange updatedStockExchange = stockExchangeService.updateStockExchange(exchangeId,
				stockExchangeDetails);
		return new ResponseEntity<>(updatedStockExchange, HttpStatus.OK);
	}

	@DeleteMapping("${api.stock-exchange.delete-path}")
	public ResponseEntity<Void> deleteStockExchangeById(@PathVariable int exchangeId) {
		stockExchangeService.deleteStockExchangeById(exchangeId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
