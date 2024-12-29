package finki.das.StocksDataWebApp.repository;

import finki.das.StocksDataWebApp.model.MovingAverage;
import finki.das.StocksDataWebApp.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovingAverageRepository extends JpaRepository<MovingAverage, Long> {

    List<MovingAverage> findAllBySymbolAndType(String symbol, String type);
}
