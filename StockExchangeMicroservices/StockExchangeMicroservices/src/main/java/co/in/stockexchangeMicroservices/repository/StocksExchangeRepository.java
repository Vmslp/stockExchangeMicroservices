package co.in.stockexchangeMicroservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.in.stockexchangeMicroservices.entity.StocksExchange;

@Repository
public interface StocksExchangeRepository extends JpaRepository<StocksExchange, Integer> {

	

}
