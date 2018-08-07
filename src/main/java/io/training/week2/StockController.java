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
  private AggregatedData aggregatedData;

  public StockController(StockRepository stockRepository, StockService stockService) {
    this.stockRepository = stockRepository;
    this.stockService = stockService;
  }

  @GetMapping("/{stock}/{date}")
  public AggregatedData queryByStockAndDate(@PathVariable("stock") String stock, @PathVariable("date") String date) {
    aggregatedData = stockRepository.getDataBySymbolAndDate(stock, date);
    aggregatedData.setClosingPrice(stockRepository.getClosingPriceBySymbolAndDate(stock, date));
    return aggregatedData;
  }

  @GetMapping("month/{stock}/{date}")
  public AggregatedData queryByStockAndMonth(@PathVariable("stock") String stock, @PathVariable("date") String date) {
    aggregatedData = stockRepository.getDataBySymbolAndMonth(stock, date);
    aggregatedData.setClosingPrice(stockRepository.getClosingPriceBySymbolAndMonth(stock, date));
    return aggregatedData;
  }

  @PostMapping("/load")
  public void load() {
    stockService.loadStocks();
    stockRepository.saveAll(stockService.getStockRecordList());
  }
}
