package io.training.week2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<StockRecord, Long> {

  String dbName = "stocks";

  @Query(value = "select new io.training.week2.AggregatedData(max(s.price), min(s.price), sum(s.volume)) "
        + "from StockRecord s "
        + "where s.symbol = ?1 and function('date_format', s.date, '%Y-%m-%d') = ?2")
  AggregatedData getDataBySymbolAndDate(String symbol, String date);

  @Query(value = "select price "
      + "from " + dbName + " "
      + "where symbol = ?1 and date_format(date, '%Y-%m-%d') = ?2 "
      + "order by date desc limit 1", nativeQuery = true)
  Double getClosingPrice(String symbol, String date);



}
