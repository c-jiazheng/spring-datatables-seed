package com.github.danielpacak.seed.datatables.service;

import com.github.danielpacak.seed.datatables.datatables.DataTablesRequest;
import com.github.danielpacak.seed.datatables.datatables.DataTablesResponse;
import com.github.danielpacak.seed.datatables.domain.Employee;
import com.github.danielpacak.seed.datatables.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.github.danielpacak.seed.datatables.datatables.DataTablesResponse.newDataTablesResponseFor;

@Service
public class EmployeeService {

  @Autowired
  EmployeeRepository repository;

  @Transactional
  public DataTablesResponse<List<Employee>> findAll(final DataTablesRequest dataTablesRequest) {
    final DataTablesResponse<List<Employee>> response = newDataTablesResponseFor(dataTablesRequest);
    response.setData(repository.findAll(dataTablesRequest));
    response.setRecordsTotal(repository.countAll(dataTablesRequest));
    response.setRecordsFiltered(repository.countAll(dataTablesRequest));
    return response;
  }

}
