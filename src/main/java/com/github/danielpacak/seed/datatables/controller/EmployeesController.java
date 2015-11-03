package com.github.danielpacak.seed.datatables.controller;

import com.github.danielpacak.seed.datatables.domain.Employee;
import com.github.danielpacak.seed.datatables.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class EmployeesController {

  @Autowired
  EmployeeRepository repository;

  @RequestMapping(value = "/employees", method = RequestMethod.GET)
  public
  @ResponseBody
  List<Employee> getEmployees() {
    return repository.findAll();
  }

}
