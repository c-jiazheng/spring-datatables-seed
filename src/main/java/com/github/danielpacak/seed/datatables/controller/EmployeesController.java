package com.github.danielpacak.seed.datatables.controller;

import com.github.danielpacak.seed.datatables.datatables.DataTablesRequest;
import com.github.danielpacak.seed.datatables.datatables.DataTablesRequestParams;
import com.github.danielpacak.seed.datatables.datatables.DataTablesResponse;
import com.github.danielpacak.seed.datatables.domain.Employee;
import com.github.danielpacak.seed.datatables.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class EmployeesController {

  @Autowired
  EmployeeService service;

  @RequestMapping(value = "/employees", method = GET)
  public
  @ResponseBody
  DataTablesResponse<List<Employee>> getEmployees(@DataTablesRequestParams DataTablesRequest dataTablesRequest) {
    return service.findAll(dataTablesRequest);
  }

}
