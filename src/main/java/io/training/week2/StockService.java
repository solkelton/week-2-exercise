package io.training.week2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class StockService {
  private final String stockUrl = "https://bootcamp-training-files.cfapps.io/week2/week2-stocks.json";
  private List<StockRecord> stockRecordList;
  private final ObjectMapper objectMapper = new ObjectMapper();
  private final TypeFactory typeFactory = objectMapper.getTypeFactory();

  public void loadStocks() {
    try {
      URL jsonUrl = new URL(stockUrl);
      stockRecordList = objectMapper.readValue(jsonUrl, typeFactory.constructCollectionType(List.class, StockRecord.class));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public List<StockRecord> getStockRecordList(){
    return stockRecordList;
  }
}
