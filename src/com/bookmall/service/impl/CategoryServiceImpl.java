package com.bookmall.service.impl;

import java.util.List;

import com.bookmall.bean.Category;
import com.bookmall.dao.CategoryDao;
import com.bookmall.dao.impl.CategoryDaoImpl;
import com.bookmall.service.CategoryService;

public class CategoryServiceImpl implements CategoryService{

	@Override
	public Category getCidByname(String canme) throws Exception {
		// TODO Auto-generated method stub
		CategoryDao cd=new CategoryDaoImpl();
		return cd.getCidByname(canme);
	}



	@Override
	public List<String> getCatePname() throws Exception {
		// TODO Auto-generated method stub
		CategoryDao cd=new CategoryDaoImpl();
		return cd.getCatePname();
	}

	@Override
	public List<String> getCateCname() throws Exception {
		// TODO Auto-generated method stub
		CategoryDao cd=new CategoryDaoImpl();
		return cd.getCateCname();
	}



	@Override
	public Category getCateBycid(int cid) throws Exception {
		// TODO Auto-generated method stub
		CategoryDao cd=new CategoryDaoImpl();
		return cd.getCidBycid(cid);
	}



	@Override
	public List<Category> getCidBypid(int pid) throws Exception {
		// TODO Auto-generated method stub
		CategoryDao cd=new CategoryDaoImpl();
		return cd.getCateBypid(pid);
	}

}
