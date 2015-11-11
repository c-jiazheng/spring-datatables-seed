package com.github.danielpacak.seed.datatables.domain;


import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Employee {

  private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-mm-DD");

  private Long id;
  private String firstName;
  private String lastName;
  private String position;
  private String office;
  private Integer age;
  private Date startDate;
  private BigDecimal salary;

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj instanceof Employee) {
      Employee that = (Employee) obj;
      return Objects.equals(this.id, that.id)
        && Objects.equals(this.firstName, that.firstName)
        && Objects.equals(this.lastName, that.lastName)
        && Objects.equals(this.position, that.position)
        && Objects.equals(this.office, that.office)
        && Objects.equals(this.age, that.age)
        && Objects.equals(this.startDate, that.startDate)
        && Objects.equals(this.salary, that.salary);
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id, this.firstName, this.lastName, this.position, this.office, this.age, this.startDate, this.salary);
  }

  public Long getId() {
    return id;
  }

  public Employee setId(Long id) {
    this.id = id;
    return this;
  }

  public String getFirstName() {
    return firstName;
  }

  public Employee setFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public String getLastName() {
    return lastName;
  }

  public Employee setLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public String getPosition() {
    return position;
  }

  public Employee setPosition(String position) {
    this.position = position;
    return this;
  }

  public String getOffice() {
    return office;
  }

  public Employee setOffice(String office) {
    this.office = office;
    return this;
  }

  public Integer getAge() {
    return age;
  }

  public Employee setAge(Integer age) {
    this.age = age;
    return this;
  }

  public Date getStartDate() {
    return startDate;
  }

  public Employee setStartDate(Date startDate) {
    this.startDate = startDate;
    return this;
  }

  public Employee setStartDate(String startDate) {
    try {
      return setStartDate(SIMPLE_DATE_FORMAT.parse(startDate));
    } catch (ParseException e) {
      throw new IllegalArgumentException(e);
    }
  }

  public BigDecimal getSalary() {
    return salary;
  }

  public Employee setSalary(BigDecimal salary) {
    this.salary = salary;
    return this;
  }
}
