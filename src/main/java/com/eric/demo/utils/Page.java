package com.eric.demo.utils;

import com.eric.demo.constant.Constant;

import java.util.List;

public class Page {

    private int pageNo = Constant.DEFAULT_PAGENO;

    private int pageSize = Constant.DEFAULT_PAGESIZE;

    private int total = Constant.DEFAULT_PAGESIZE;

    private int begin = 0;

    private int totalPage=1;
    /**
     * 第一页 页号
     */
    private int first = 1;
    /**
     * 最后页 页号
     */
    private int last;
    /**
     * 页号式导航, 起始页号
     */
    private int start;
    /**
     * 页号式导航, 结束页号
     */
    private int end;
    /**
     * 页号式导航, 显示页号数量
     */
    private int numCount = 5;

    private List<?> data;


    /**
     *
     * @param _pageNo 页面
     * @param _pageSize 分页大小
     * @param _total 总数据量
     */
    public Page(Integer _pageNo, Integer _pageSize, Integer _total) {
        super();
        _pageNo = _pageNo==null?0:_pageNo;
        _pageSize = _pageSize==null?0:_pageSize;
        _total = _total==null?0:_total;

        _pageSize=_pageSize<1? Constant.DEFAULT_PAGESIZE:_pageSize;

        _pageNo=_pageNo<1?1:_pageNo;

        //_total=_total<0?Constant.DEFAULT_PAGESIZE:_total;

        this.pageSize = _pageSize;
        this.total = _total;
        this.totalPage = _total/_pageSize+(_total%_pageSize==0?0:1);
        //this.pageNo = _pageNo>totalPage?totalPage:_pageNo;
        this.pageNo = _pageNo;

        this.begin = (this.pageNo-1)*this.pageSize;


        //计算最后页号
        this.last = this.totalPage;//最后页号等于总页数count
        //计算page 起始页号
        start = Math.max(this.pageNo-numCount/2, first);//first=1 numCount=10(导航数目) 算起始导航，第num=7开始动 start=2
        //计算page 结束页号
        end = Math.min(start+numCount-1, last);//小于等于最后页   num=7 start=2 end = 2+10-1=11
        if(end-start < numCount-1){//（判断结束页-导航起始）小于（导航数目 -1） 页码最后不够的时候  （start最小也是1  所以numCount-1比较）
            start = Math.max(end-numCount+1, 1);
        }
    }


    public Page(Page page){
        this(page.getPageNo(),page.getPageSize(),page.getTotal());
    }

    public int getPageNo() {
        return pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getTotal() {
        return total;
    }

    public int getBegin() {
        return begin<0?0:begin;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public List<?> getData() {
        return data;
    }


    public void setData(List<?> data) {
        this.data = data;
    }

    /**
     * @return the start
     */
    public int getStart() {
        return start;
    }


    /**
     * @return the end
     */
    public int getEnd() {
        return end;
    }


    //@Override
    public String toString() {
        return "Page [pageNo=" + pageNo + ", pageSize=" + pageSize + ", total=" + total + ", begin=" + begin
                + ", totalPage=" + totalPage + "]";
    }
}
