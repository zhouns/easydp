package com.sgepm.easydp.common.entity;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

@SuppressWarnings({"unused", "rawtypes"})
public class Pagination {
	
	private Integer draw = 1;			//请求次数
	private Integer pageNo;				//第几页
	private Integer pageSize;			//每页条数
	private Integer totalNo;			//总页数
	private Integer recordsTotal;		//总条数
	private Integer recordsFiltered;	//过滤后总条数
	private List data;					//数据集
	private Integer srt;				//开始下标
	private Integer end;				//结束下标
	
	public Pagination(Integer pageNo, Integer pageSize,
			Integer recordsTotal) {
		super();
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.recordsTotal = recordsTotal;
	}

	public Pagination(Integer draw, Integer pageNo, Integer pageSize,
			Integer recordsTotal) {
		super();
		this.draw = draw;
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.recordsTotal = recordsTotal;
		this.recordsFiltered = recordsTotal;
	}

	public Integer getDraw() {
		return draw;
	}

	public void setDraw(Integer draw) {
		this.draw = draw;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getTotalNo() {
		return totalNo;
	}

	public void setTotalNo(Integer totalNo) {
		this.totalNo = totalNo;
	}

	public Integer getRecordsTotal() {
		return (recordsTotal % pageSize == 0) ? (recordsTotal / pageSize) : (recordsTotal
				/ pageSize + 1);
	}

	public void setRecordsTotal(Integer recordsTotal) {
		this.recordsTotal = recordsTotal;
	}

	public Integer getRecordsFiltered() {
		return recordsFiltered;
	}

	public void setRecordsFiltered(Integer recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}

	public List getData() {
		return data;
	}

	public void setData(List data) {
		this.data = data;
	}

	public Integer getSrt() {
		return (pageNo <= 1) ? 0 : (pageNo - 1) * pageSize;
	}

	public void setSrt(Integer srt) {
		this.srt = srt;
	}

	public Integer getEnd() {
		return (pageNo * pageSize > recordsTotal) ? recordsTotal
				: (getSrt() + pageSize);
	}

	public void setEnd(Integer end) {
		this.end = end;
	}
	
}
