package com.github.danielpacak.seed.datatables.repository;

import com.github.danielpacak.seed.datatables.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EmployeeRepositoryJdbcImpl implements EmployeeRepository {

  @Autowired
  JdbcTemplate jdbcTemplate;

  @Override
  public List<Employee> findAll(int start, int length) {
    return jdbcTemplate.query("SELECT ID, FIRST_NAME, LAST_NAME, POSITION, OFFICE, AGE, START_DATE, SALARY FROM EMPLOYEE LIMIT ? OFFSET ?", new Object[]{length, start}, new RowMapper<Employee>() {
      @Override
      public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
        Employee employee = new Employee();
        employee.setId(resultSet.getLong("ID"));
        employee.setFirstName(resultSet.getString("FIRST_NAME"));
        employee.setLastName(resultSet.getString("LAST_NAME"));
        employee.setPosition(resultSet.getString("POSITION"));
        employee.setOffice(resultSet.getString("OFFICE"));
        employee.setAge(resultSet.getInt("AGE"));
        employee.setStartDate(resultSet.getDate("START_DATE"));
        employee.setSalary(resultSet.getBigDecimal("SALARY"));
        return employee;
      }
    });
  }

  @Override
  public long countAll() {
    return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM EMPLOYEE", Long.class);
  }
}
