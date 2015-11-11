package com.github.danielpacak.seed.datatables.controller;

import com.github.danielpacak.seed.datatables.Application;
import com.github.danielpacak.seed.datatables.datatables.DataTablesResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.net.URL;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest({"server.port=0"})
public class EmployeesControllerIT {

  @Value("${local.server.port}")
  private int port;

  private URI base;

  private RestTemplate template;

  @Before
  public void beforeEach() throws Exception {
    this.base = new URL("http://localhost:" + port + "/").toURI();
    this.template = new TestRestTemplate();
  }

  @Test
  public void getEmployees() {
    String url = UriComponentsBuilder.fromUri(base)
      .path("/employees")
      .queryParam("draw", 1)
      .queryParam("start", 0)
      .queryParam("length", 10)
      .build().toUriString();

    DataTablesResponse response = template.getForObject(url, DataTablesResponse.class);
    assertThat(response.getDraw(), equalTo(1));
    assertThat(response.getRecordsFiltered(), equalTo(22L));
    assertThat(response.getRecordsTotal(), equalTo(22L));
  }

}
