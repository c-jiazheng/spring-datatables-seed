package com.github.danielpacak.seed.datatables.datatables;

public class DataTablesResponse<T> {

  private Integer draw;

  private T data;

  private Long recordsTotal;

  private Long recordsFiltered;

  public static <T> DataTablesResponse<T> newDataTablesResponseFor(DataTablesRequest request) {
    DataTablesResponse<T> r = new DataTablesResponse<>();
    r.setDraw(request.getDraw());
    return r;
  }

  public void setDraw(Integer draw) {
    this.draw = draw;
  }

  public Integer getDraw() {
    return draw;
  }

  public void setData(T data) {
    this.data = data;
  }

  public T getData() {
    return data;
  }

  public void setRecordsTotal(Long recordsTotal) {
    this.recordsTotal = recordsTotal;
  }

  public Long getRecordsTotal() {
    return recordsTotal;
  }

  public void setRecordsFiltered(Long recordsFiltered) {
    this.recordsFiltered = recordsFiltered;
  }

  public Long getRecordsFiltered() {
    return recordsFiltered;
  }
}
