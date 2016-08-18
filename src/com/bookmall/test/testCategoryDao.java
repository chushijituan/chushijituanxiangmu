package com.bookmall.test;

import java.util.ArrayList;
import java.util.List;

import com.bookmall.bean.Category;
import com.bookmall.service.CategoryService;
import com.bookmall.service.impl.CategoryServiceImpl;

public class testCategoryDao {
	public static void main(String[] args) throws Throwable {
		List<String> list=new ArrayList<String>();
		CategoryService cs=new CategoryServiceImpl();
		list=cs.getCatePname();
		for(String str:list)
		System.out.println(str);
		list=cs.getCateCname();
		for(String str:list)
		System.out.println(str);
		int pid=cs.getCidByname("½ÌÓý").getCid();
		System.out.println(pid);
		List<Category> li=cs.getCidBypid(pid);
		for(Category category:li)
		System.out.println(category);
	}
}
