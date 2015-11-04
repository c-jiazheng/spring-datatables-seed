# Spring (4.x) MVC DataTables (1.10.x) Seed

![Screenshot](/README/spring-datatables.png)

```shell
$ mvn spring-boot:run
```

## URLs to play around

* [http://localhost:8080/index.html](http://localhost:8080/index.html)
* [http://localhost:8080/health](http://localhost:8080/health)
* [http://localhost:8080/env](http://localhost:8080/env)
* [http://localhost:8080/mappings](http://localhost:8080/mappings)
* [http://localhost:8080/metrics](http://localhost:8080/metrics)
* [http://localhost:8080/webjars/jquery/1.11.3/jquery.js](http://localhost:8080/webjars/jquery/1.11.3/jquery.js)
* [http://localhost:8080/webjars/datatables/1.10.9/js/jquery.dataTables.js](http://localhost:8080/webjars/datatables/1.10.9/js/jquery.dataTables.js)

## Implementation

### By an IT contractor (currently in this repo)

```java
package com.github.danielpacak.seed.datatables.controller;

import com.github.danielpacak.seed.datatables.datatables.DataTablesRequest;
import com.github.danielpacak.seed.datatables.datatables.DataTablesRequestParams;
import com.github.danielpacak.seed.datatables.datatables.DataTablesResponse;
import com.github.danielpacak.seed.datatables.domain.Employee;
import com.github.danielpacak.seed.datatables.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class EmployeesController {

  @Autowired
  EmployeeService service;

  @RequestMapping(value = "/employees", method = RequestMethod.GET)
  public
  @ResponseBody
  DataTablesResponse<List<Employee>> getEmployees(@DataTablesRequestParams DataTablesRequest dataTablesRequest) {
    return service.findAll(dataTablesRequest);
  }

}

```

### By a student / stack overflow-er

TODO

## Notes

> By default Spring Boot will serve static content from a directory called `/static` (or `/public` or `/resources` or
> `/META-INF/resources`) in the classpath or from the root of the `ServletContext`.

> In addition to the 'standard' static resources locations above, a special case is made for Webjars content.
> Any resources with a path `/webjars/**` will be served from jar files if they are packed in the Webjar format.

## Reference

* https://www.datatables.net/examples/basic_init/alt_pagination.html
* http://docs.spring.io/spring-boot/docs/current/reference/html/howto-database-initialization.html

## Read as a follow up to this exercise

* http://docs.spring.io/spring-boot/docs/1.2.7.RELEASE/reference/htmlsingle/#production-ready
