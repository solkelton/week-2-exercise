package io.training.week2;

public class AggregatedData {

  private Double maxPrice;
  private Double minPrice;
  private Long volume;

  public AggregatedData(Double maxPrice, Double minPrice, Long volume) {
    this.maxPrice = maxPrice;
    this.minPrice = minPrice;
    this.volume = volume;
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
}
