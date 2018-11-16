package com.eric.demo.db.search;

import com.eric.demo.constant.Constant;

public class BaseSearch {
    protected int pageSize = Constant.DEFAULT_PAGESIZE;
    protected int pageNo =	Constant.DEFAULT_PAGENO;
    protected int begin = 0;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getBegin() {
        return begin;
    }

    public void setBegin(int begin) {
        this.begin = begin;
    }

    public BaseSearch() {
        super();
    }

    public BaseSearch(int pageSize, int begin) {
        super();
        this.pageSize = pageSize;
        this.begin = begin;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }
}
