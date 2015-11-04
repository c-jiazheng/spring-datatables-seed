package com.github.danielpacak.seed.datatables.repository;

import com.github.danielpacak.seed.datatables.domain.Employee;

import java.util.List;

public interface EmployeeRepository {

  List<Employee> findAll(int start, int length);

  long countAll();

}
