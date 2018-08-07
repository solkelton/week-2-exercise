package io.training.week2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stocks")
public class StockController {

  private final StockRepository stockRepository;
  private StockService stockService;

  public StockController(StockRepository stockRepository, StockService stockService) {
    this.stockRepository = stockRepository;
    this.stockService = stockService;
  }

  @GetMapping("/{stock}/{date}")
  public AggregatedData queryByStockAndDate(@PathVariable("stock") String stock, @PathVariable("date") String date) {
    return stockRepository.getDataBySymbolAndDate(stock, date);
  }

  @PostMapping("/load")
  public void load() {
    stockService.loadStocks();
    stockRepository.saveAll(stockService.getStockRecordList());
  }
}
