package io.training.week2;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stocks")
public class StockRecord {

  @Id
  @GeneratedValue
  @Column
  public long id;

  @Column
  public String symbol;
  @Column
  public double price;
  @Column
  public int volume;
  @Column
  public Timestamp date;

  public StockRecord(long id, String symbol, double price, int volume, Timestamp date) {
    this.id = id;
    this.symbol = symbol;
    this.price = price;
    this.volume = volume;
    this.date = date;
  }

  public StockRecord(){}

  public long getId() {
    return id;
  }

  public String getSymbol() {
    return symbol;
  }

  public double getPrice() {
    return price;
  }

  public int getVolume() {
    return volume;
  }

  public Timestamp getDate() {
    return date;
  }

  public void setId(long id) {
    this.id = id;
  }

  public void setSymbol(String symbol) {
    this.symbol = symbol;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public void setVolume(int volume) {
    this.volume = volume;
  }

  public void setDate(Timestamp date) {
    this.date = date;
  }

}
