package com.bookmall.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bookmall.bean.Pages;


public class PageUtil {
		public  static Pages getPage(int pageIndex,int pagesize,String sql) throws Exception{
		int count =-1;//总数居条数
		int pageCount=-1;//总页数
		int start=-1;
		int end=-1;
		Connection conn=DBUtil.getConnection();
		PreparedStatement ps=conn.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
	
		
		while(rs.next())
		{
			count=rs.getInt(1);
		}
		
		pageCount =count%pagesize==0?count/pagesize:count/pagesize+1;
		
		start=(pageIndex-1)*pagesize+1;
		if(count<pagesize){
			end=count;
		}else{
			end=pageIndex*pagesize;
		}
		
		Pages pages=new Pages(count,pageCount,start,end);
		
		DBUtil.getClose(conn, ps, rs);
		return pages;
		}
}
