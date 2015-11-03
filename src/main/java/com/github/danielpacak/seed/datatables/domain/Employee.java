package com.github.danielpacak.seed.datatables.domain;


import java.math.BigDecimal;
import java.util.Date;

public class Employee {

  private Long id;
  private String name;
  private String position;
  private String office;
  private Integer age;
  private Date startDate;
  private BigDecimal annualGrossSalary;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }

  public String getOffice() {
    return office;
  }

  public void setOffice(String office) {
    this.office = office;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public BigDecimal getAnnualGrossSalary() {
    return annualGrossSalary;
  }

  public void setAnnualGrossSalary(BigDecimal annualGrossSalary) {
    this.annualGrossSalary = annualGrossSalary;
  }

}
