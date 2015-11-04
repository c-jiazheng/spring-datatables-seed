package com.github.danielpacak.seed.datatables.controller;

import com.github.danielpacak.seed.datatables.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class EmployeesController {

  @Autowired
  EmployeeRepository repository;

  @RequestMapping(value = "/employees", method = RequestMethod.GET)
  public
  @ResponseBody
  Map<String, Object> getEmployees(@RequestParam("start") int start, @RequestParam("length") int length, HttpServletRequest httpRequest) {
    Map<String, Object> response = new HashMap<>();
    response.put("draw", httpRequest.getParameter("draw"));
    response.put("data", repository.findAll(start, length));
    response.put("recordsTotal", repository.countAll());
    response.put("recordsFiltered", repository.countAll());
    return response;
  }

}
