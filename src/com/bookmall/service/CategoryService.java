package com.bookmall.service;

import java.util.List;

import com.bookmall.bean.Category;

public interface CategoryService {
	public Category getCidByname(String canme) throws Exception;
	public Category getCateBycid(int cid) throws Exception;
	public List<Category> getCidBypid(int pid) throws Exception;
	public List<String> getCatePname() throws Exception;
	public List<String> getCateCname() throws Exception;
}
