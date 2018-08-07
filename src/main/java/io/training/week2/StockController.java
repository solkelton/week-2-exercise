package io.training.week2;

import java.awt.print.Pageable;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
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
    aggregatedData.setClosingPrice(stockRepository.getClosingPrice(stock, date));
    return aggregatedData;
  }

  @PostMapping("/load")
  public void load() {
    stockService.loadStocks();
    stockRepository.saveAll(stockService.getStockRecordList());
  }
}
