package com.alex.common.db.postgres.pagination;

public class Pageable {
  private final int DEFAULT_PAGE_SIZE = 100;
  public int pageSize = DEFAULT_PAGE_SIZE;
  public int pageNum = 0;
  public boolean paging = true;

  public Pageable(){}
  public Pageable(int pageNum){
    this.pageNum = pageNum + 1;
  }
  public Pageable nextPage(){
    return new Pageable(pageNum = this.pageNum + 1);
  }
}