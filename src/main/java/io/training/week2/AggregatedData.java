package io.training.week2;

public class AggregatedData{

  private Double maxPrice;
  private Double minPrice;
  private Long volume;
  private Double closingPrice;

  public AggregatedData(Double maxPrice, Double minPrice, Long volume) {
    this.maxPrice = maxPrice;
    this.minPrice = minPrice;
    this.volume = volume;
    this.closingPrice = -1.0;
  }

  public Double getMaxPrice() {
    return maxPrice;
  }

  public void setMaxPrice(Double maxPrice) {
    this.maxPrice = maxPrice;
  }

  public Double getMinPrice() {
    return minPrice;
  }

  public void setMinPrice(Double minPrice) {
    this.minPrice = minPrice;
  }

  public Long getVolume() {
    return volume;
  }

  public void setVolume(Long volume) {
    this.volume = volume;
  }

  public Double getClosingPrice() {
    return closingPrice;
  }

  public void setClosingPrice(Double closingPrice) {
    this.closingPrice = closingPrice;
  }
}
