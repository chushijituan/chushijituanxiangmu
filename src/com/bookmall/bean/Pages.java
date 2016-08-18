package com.bookmall.bean;

public class Pages {
	private int count;
	private int pageCount;
	private int start;
	private int end;
	public Pages() {
		super();
	}
	public Pages(int count, int pageCount, int start, int end) {
		super();
		this.count = count;
		this.pageCount = pageCount;
		this.start = start;
		this.end = end;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	}
