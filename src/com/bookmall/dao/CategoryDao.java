package com.bookmall.dao;

import java.util.List;

import com.bookmall.bean.Category;

public interface CategoryDao {
	public Category getCidByname(String canme) throws Exception;
	public Category getCidBycid(int cid) throws Exception;
	public List<Category> getCateBypid(int pid) throws Exception;
	public List<String> getCatePname() throws Exception;
	public List<String> getCateCname() throws Exception;
}
