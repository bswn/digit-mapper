package com.alphasoft.digitmapper.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "digits")
public class Digit {

  private Long id;
  private Integer divisor;
  private String category;
  private String mappedDivisor;

  public Integer getDivisor() {
    return divisor;
  }

  public void setDivisor(Integer divisor) {
    this.divisor = divisor;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getMappedDivisor() {
    return mappedDivisor;
  }

  public void setMappedDivisor(String mappedDivisor) {
    this.mappedDivisor = mappedDivisor;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @Id
  public Long getId() {
    return id;
  }
}
