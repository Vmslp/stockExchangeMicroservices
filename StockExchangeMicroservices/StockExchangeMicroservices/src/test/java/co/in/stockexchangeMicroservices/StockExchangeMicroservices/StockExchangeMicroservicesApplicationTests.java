package co.in.stockexchangeMicroservices.StockExchangeMicroservices;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import co.in.stockexchangeMicroservices.entity.StocksExchange;
import co.in.stockexchangeMicroservices.repository.StocksExchangeRepository;
import co.in.stockexchangeMicroservices.service.StocksExchangeServiceImpl;

@SpringBootTest
class StocksExchangeServiceImplTest {

    @Mock
    private StocksExchangeRepository stocksExchangeRepository;

    @InjectMocks
    private StocksExchangeServiceImpl stocksExchangeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testgetAllStockExchanges() {
        List<StocksExchange> exchanges = List.of(
                new StocksExchange(1, "Bombay Stocks Exchange", "New York Stock Exchanged"),
                new StocksExchange(2, "National Stocks Exchange", "National Association of Securities Dealers Automated Quotations")
        );

        when(stocksExchangeRepository.findAll()).thenReturn(exchanges);

        List<StocksExchange> result = stocksExchangeService.getAllStockExchanges();

        assertNotNull(result, "Result should not be null");
        assertEquals(exchanges.size(), result.size(), "Size of the result list should match");
        assertEquals(exchanges, result, "List of stock exchanges should match");
        verify(stocksExchangeRepository).findAll();
    }

    @Test
    void testgetStockExchangeById() {
        int exchangeId = 1;
        StocksExchange exchange = new StocksExchange(exchangeId, "Bombay Stocks Exchange", "New York Stock Exchanged");

        when(stocksExchangeRepository.findById(exchangeId)).thenReturn(Optional.of(exchange));

        Optional<StocksExchange> result = stocksExchangeService.getStockExchangeById(exchangeId);

        assertTrue(result.isPresent(), "Exchange should be found");
        assertEquals(exchange, result.get(), "Exchange object should match");
        verify(stocksExchangeRepository).findById(exchangeId);
    }

    @Test
    void testupdateStockExchange() {
        int exchangeId = 1;
        StocksExchange existingExchange = new StocksExchange(exchangeId, "Bombay Stocks Exchange", "New York Stock Exchanged");
        StocksExchange updatedDetails = new StocksExchange(exchangeId, "NYSE", "Updated Description");

        when(stocksExchangeRepository.findById(exchangeId)).thenReturn(Optional.of(existingExchange));
        when(stocksExchangeRepository.save(existingExchange)).thenReturn(updatedDetails);

        StocksExchange result = stocksExchangeService.updateStockExchange(exchangeId, updatedDetails);

        assertNotNull(result, "Result should not be null");
        assertEquals(updatedDetails.getDescription(), result.getDescription(), "Description should be updated");
        verify(stocksExchangeRepository).findById(exchangeId);
        verify(stocksExchangeRepository).save(existingExchange);
    }

    @Test
    void testdeleteStockExchangeById() {
        int exchangeId = 1;

        doNothing().when(stocksExchangeRepository).deleteById(exchangeId);

        stocksExchangeService.deleteStockExchangeById(exchangeId);

        verify(stocksExchangeRepository).deleteById(exchangeId);
    }

    @Test
    void testcreateStockExchange() {
        StocksExchange newExchange = new StocksExchange(1, "Bombay Stocks Exchange", "New York Stock Exchanged");

        when(stocksExchangeRepository.save(newExchange)).thenReturn(newExchange);

        StocksExchange result = stocksExchangeService.createStockExchange(newExchange);

        assertNotNull(result, "Result should not be null");
        assertEquals(newExchange, result, "Created stock exchange should match");
        verify(stocksExchangeRepository).save(newExchange);
    }
}

