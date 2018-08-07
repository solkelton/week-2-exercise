package io.training.week2;

import javax.persistence.EntityManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<StockRecord, Long> {

  @Query(value = "select new io.training.week2.AggregatedData(max(s.price), min(s.price), sum(s.volume)) " +
        "from StockRecord s, StockRecord s2 "
      + "where s.symbol = ?1 and function('date_format', s.date, '%Y-%m-%d') = ?2 ")
  AggregatedData getDataBySymbolAndDate(String symbol, String date);


}
