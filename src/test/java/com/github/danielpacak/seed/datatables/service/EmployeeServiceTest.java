package com.github.danielpacak.seed.datatables.service;

import com.github.danielpacak.seed.datatables.datatables.DataTablesRequest;
import com.github.danielpacak.seed.datatables.datatables.DataTablesResponse;
import com.github.danielpacak.seed.datatables.domain.Employee;
import com.github.danielpacak.seed.datatables.repository.EmployeeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTest {

  @Mock
  private EmployeeRepository repository;

  @InjectMocks
  private EmployeeService service;

  @Test
  public void findAllShouldReturnDataTablesResponse() {
    DataTablesRequest tableRequest = new DataTablesRequest();
    tableRequest.setDraw(15);
    tableRequest.setStart(0);
    tableRequest.setLength(10);

    List<Employee> employees = new ArrayList<>();

    given(repository.findAll(tableRequest)).willReturn(employees);
    given(repository.countAll(tableRequest)).willReturn(new Long(employees.size()));

    DataTablesResponse<List<Employee>> tableResponse = service.findAll(tableRequest);

    assertEquals(tableRequest.getDraw(), tableResponse.getDraw());
    assertEquals(employees, tableResponse.getData());
    assertEquals(new Long(employees.size()), tableResponse.getRecordsTotal());
    assertEquals(new Long(employees.size()), tableResponse.getRecordsFiltered());
  }
}
