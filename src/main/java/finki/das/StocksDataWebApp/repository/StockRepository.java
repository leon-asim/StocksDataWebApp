package finki.das.StocksDataWebApp.repository;

import finki.das.StocksDataWebApp.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {

    List<Stock> findAllBySymbol(String symbol);

}
