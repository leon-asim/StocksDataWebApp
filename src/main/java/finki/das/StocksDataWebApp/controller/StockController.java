package finki.das.StocksDataWebApp.controller;

import finki.das.StocksDataWebApp.model.Stock;
import finki.das.StocksDataWebApp.service.StockService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/stocks")
//@Validated
//@CrossOrigin(origins="*")
public class StockController {

    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping
    public ResponseEntity<List<Stock>> getAllStockData() {
        List<Stock> stocks = stockService.findAll();
        return ResponseEntity.ok(stocks);  // Returns 200 OK with the list of stocks
    }

    @PostMapping
    public ResponseEntity<Stock> createStockData(@RequestBody Stock stockData) {
        Stock createdStock = stockService.save(stockData);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStock);  // Returns 201 Created with the created stock
    }

    @GetMapping("/{id}")
    public ResponseEntity<Stock> getStockDataById(@PathVariable Long id) {
        return stockService.findById(id)
                .map(stock -> ResponseEntity.ok(stock))  // Returns 200 OK with the stock
                .orElseGet(() -> ResponseEntity.notFound().build());  // Returns 404 Not Found if stock is not present
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStockData(@PathVariable Long id) {
        if (stockService.existsById(id)) {
            stockService.deleteById(id);
            return ResponseEntity.noContent().build();  // Returns 204 No Content for successful deletion
        }
        return ResponseEntity.notFound().build();  // Returns 404 Not Found if the stock doesn't exist
    }

    @GetMapping("/symbol/{symbol}")
    public ResponseEntity<List<Stock>> getStockDataBySymbol(@PathVariable String symbol) {
        List<Stock> stocks = stockService.findAllBySymbol(symbol);

        if (stocks.isEmpty()) {
            return ResponseEntity.notFound().build();  // Returns 404 Not Found if no stocks are found with the symbol
        }

        return ResponseEntity.ok(stocks);  // Returns 200 OK with the list of stocks
    }






//    @GetMapping
//    public List<Stock> getAllStockData() {
//        return stockService.findAll();
//    }
//
//    @PostMapping
//    public Stock createStockData(@RequestBody Stock stockData) {
//        return stockService.save(stockData);
//    }
//
//    @GetMapping("/{id}")
//    public Stock getStockDataById(@PathVariable Long id) {
//        return stockService.findById(id).get();
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteStockData(@PathVariable Long id) {
//        stockService.deleteById(id);
//    }
}
