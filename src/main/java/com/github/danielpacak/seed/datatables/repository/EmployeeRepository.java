package com.github.danielpacak.seed.datatables.repository;

import com.github.danielpacak.seed.datatables.datatables.DataTablesRequest;
import com.github.danielpacak.seed.datatables.domain.Employee;

import java.util.List;

public interface EmployeeRepository {

  List<Employee> findAll(DataTablesRequest tablesRequest);

  long countAll(DataTablesRequest tablesRequest);

}
