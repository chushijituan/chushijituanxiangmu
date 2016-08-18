package com.bookmall.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bookmall.bean.Seller;
import com.bookmall.bean.User;
import com.bookmall.dao.UserDao;
import com.bookmall.utils.DBUtil;

public class UserDaoImpl implements UserDao {
	private Connection conn=null;
	private PreparedStatement ps =null;
	private ResultSet rs =null;
	
	//userע��
	@Override
	public User registerUser(User user) throws ClassNotFoundException, SQLException {
		conn=DBUtil.getConnection();
		String sql="insert into COMUSER values (SE_9.nextval,?,?,?,?)";
		ps=conn.prepareStatement(sql);
		ps.setString(1, user.getLoginname());
		ps.setString(2, user.getLoginpass());
		ps.setString(3, user.getEmail());
		ps.setString(4, user.getUphone());
		ps.executeUpdate();
		return user;
	}

	//����û�������������û�
	@Override
	public boolean findUser(String loginname, String loginpass) throws SQLException, ClassNotFoundException {
		conn=DBUtil.getConnection();
		boolean valid=false;
		String sql="select * from COMUSER where loginname=? and loginpass=? ";
		ps=conn.prepareStatement(sql);
		ps.setString(1, loginname);
		ps.setString(2, loginpass);
		rs=ps.executeQuery();
		if(rs.next()){
			valid=true;
			DBUtil.getClose(conn, ps, rs);
			return valid;
		}else {			
			DBUtil.getClose(conn, ps, rs);
			return valid;
		}
	}

	@Override
	public User updateUser(User user) throws SQLException, ClassNotFoundException {
		conn=DBUtil.getConnection();
		String sql="update COMUSER set loginname=?,loginpass=?,email=? where cosuid=?";
		ps=conn.prepareStatement(sql);
		ps.setString(1, user.getLoginname());
		ps.setString(2, user.getLoginpass());
		ps.setString(3, user.getEmail());
		ps.setInt(4, user.getCosuid());
		ps.executeUpdate();
		DBUtil.getClose(conn, ps,rs);
		//System.out.println("345"+user);
		return user;
	}

	@Override
	public boolean deleteUser(int cosuid) throws ClassNotFoundException, SQLException {
		boolean valid=false;
		conn=DBUtil.getConnection();	
		String sql="delete from COMUSER where cosuid=?";
		ps=conn.prepareStatement(sql);
		ps.setInt(1, cosuid);
		if(ps.executeUpdate()==0){
			valid=true;
			DBUtil.getClose(conn, ps, rs);
			return valid;
		}else{			
			DBUtil.getClose(conn, ps, rs);
			return valid;
		}
	}

	@Override
	public List<User> getAllUser() throws ClassNotFoundException, SQLException {
		List<User> list=new ArrayList<User>();
		conn=DBUtil.getConnection();
		String sql="select * from COMUSER";
		ps=conn.prepareStatement(sql);
		rs=ps.executeQuery();
		while(rs.next()){
			User user=new User();
			user.setCosuid(rs.getInt("cosuid"));;
			user.setLoginname(rs.getString("loginname"));
			user.setLoginpass(rs.getString("loginpass"));
			user.setEmail(rs.getString("email"));
			user.setUphone(rs.getString("uphone"));
			list.add(user);
		}
		DBUtil.getClose(conn, ps, rs);
		return list;
	}

	@Override
	public User findUser1(String loginname) throws ClassNotFoundException, SQLException {
		conn=DBUtil.getConnection();
		String sql="select * from COMUSER where loginname=? ";
		ps=conn.prepareStatement(sql);
		ps.setString(1, loginname);
		rs=ps.executeQuery();
		User user=new User();
		while(rs.next()){
			user.setCosuid(rs.getInt("cosuid"));
			user.setLoginname(rs.getString("loginname"));
			user.setLoginpass(rs.getString("loginpass"));
			user.setEmail(rs.getString("email"));
			user.setUphone(rs.getString("uphone"));
		}
		return user;
		
		
	}

	@Override
	public boolean deleteCARTITEM(int cosuid) throws ClassNotFoundException, SQLException {
		boolean valid=false;
		conn=DBUtil.getConnection();
		String sql="delete from CARTITEM where cosuid=?";
		ps=conn.prepareStatement(sql);
		ps.setInt(1, cosuid);
		ps.executeUpdate();
		if(ps.executeUpdate()!=0){
			valid=true;
			DBUtil.getClose(conn, ps, rs);
			return valid;
		}else{			
			DBUtil.getClose(conn, ps, rs);
			return valid;
		}
	}

	@Override
	public boolean deleteUSERORDER(int cosuid) throws ClassNotFoundException, SQLException {
		boolean valid=false;
		conn=DBUtil.getConnection();
		String sql="delete from USERORDER where cosuid=?";
		ps=conn.prepareStatement(sql);
		ps.setInt(1, cosuid);
		ps.executeUpdate();
		if(ps.executeUpdate()!=0){
			valid=true;
			DBUtil.getClose(conn, ps, rs);
			return valid;
		}else{			
			DBUtil.getClose(conn, ps, rs);
			return valid;
		}
	}

	@Override
	public User findUser2(int cosuid) throws ClassNotFoundException, SQLException {
		conn=DBUtil.getConnection();
		String sql="select * from COMUSER where cosuid=? ";
		ps=conn.prepareStatement(sql);
		ps.setInt(1, cosuid);
		rs=ps.executeQuery();
		User user=new User();
		while(rs.next()){
			user.setCosuid(rs.getInt("cosuid"));
			user.setLoginname(rs.getString("loginname"));
			user.setLoginpass(rs.getString("loginpass"));
			user.setEmail(rs.getString("email"));
			user.setUphone(rs.getString("uphone"));
		}
		return user;
	}
	
	

}
