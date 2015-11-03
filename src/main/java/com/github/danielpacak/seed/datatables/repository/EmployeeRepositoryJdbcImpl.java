package com.github.danielpacak.seed.datatables.repository;

import com.github.danielpacak.seed.datatables.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EmployeeRepositoryJdbcImpl implements EmployeeRepository {

  @Autowired
  JdbcTemplate jdbcTemplate;

  @Override
  public List<Employee> findAll() {
    return jdbcTemplate.query("SELECT ID, NAME FROM EMPLOYEE", new RowMapper<Employee>() {
      @Override
      public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
        Employee employee = new Employee();
        employee.setId(resultSet.getLong("ID"));
        employee.setName(resultSet.getString("NAME"));
        return employee;
      }
    });
  }

}
