package com.github.danielpacak.seed.datatables.datatables;

import java.util.Objects;

public class DataTablesRequest {

  private Integer draw;

  private Integer start;

  private Integer length;

  public Integer getDraw() {
    return draw;
  }

  public void setDraw(Integer draw) {
    this.draw = draw;
  }

  public Integer getStart() {
    return start;
  }

  public void setStart(Integer start) {
    this.start = start;
  }

  public Integer getLength() {
    return length;
  }

  public void setLength(Integer length) {
    this.length = length;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj instanceof DataTablesRequest) {
      DataTablesRequest that = (DataTablesRequest) obj;
      return Objects.equals(this.draw, that.draw)
        && Objects.equals(this.start, that.start)
        && Objects.equals(this.length, that.length);
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.draw, this.start, this.length);
  }

}
