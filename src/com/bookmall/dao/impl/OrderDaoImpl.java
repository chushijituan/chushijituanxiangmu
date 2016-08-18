package com.bookmall.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.itcast.jdbc.TxQueryRunner;

import com.bookmall.bean.Expression;
import com.bookmall.bean.Order;
import com.bookmall.bean.OrderItem;
import com.bookmall.bean.PageBean;
import com.bookmall.bean.PageContant;
import com.bookmall.bean.User;
import com.bookmall.dao.OrderDao;
import com.bookmall.dao.OrderItemDao;
import com.bookmall.utils.DBUtil;

public class OrderDaoImpl implements OrderDao {

	private QueryRunner qr = new TxQueryRunner();
	OrderItemDao itemDao = new OrderItemDaoImpl();

	// ��ѯ����״̬
	@Override
	public int findStatus(int oid) throws SQLException, ClassNotFoundException {
		String sql = "select status from userorder where oid=?";
		Number number = (Number) qr.query(sql, new ScalarHandler(), oid);
		return number.intValue();
	}

	// �޸Ķ���״̬
	@Override
	public void updateStatus(int oid, int status)
			throws ClassNotFoundException, SQLException {
		String sql = "update userorder set status=? where oid=?";
		qr.update(sql, status, oid);

	}

	// ���ض���
	@Override
	public Order load(int oid) throws ClassNotFoundException, SQLException {
		String sql = "select * from userorder where oid=?";
		Order order = qr.query(sql, new BeanHandler<Order>(Order.class), oid);
		itemDao.loadOrderItem(order);// Ϊ��ǰ���������������ж�����Ŀ
		return order;
	}

	// ���ɶ���
	@Override
	public void add(Order order) throws ClassNotFoundException, SQLException {
		
		
		
		
		
		
		
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		
		try {
			conn=DBUtil.getConnection();
			String sql = "insert into USERORDER(OID,ORDERTIME,STATUS,TOTAL,COSUID) values(SE_5.nextval,sysdate,?,?,?)";
		
			pst=conn.prepareStatement(sql);
			
			pst.setInt(1, order.getStatus());
			pst.setDouble(2, order.getTotal());
			pst.setInt(3,order.getOwner().getCosuid());
			
			
			pst.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.getClose(conn, pst, null);
		}
		
		//查询序列值
		
		
		
		
		
		

	}

	// ���û���ѯ����
	@Override
	public PageBean<Order> findByUser(int uid, int pc)
			throws ClassNotFoundException, SQLException {
		List<Expression> exprList = new ArrayList<Expression>();
		exprList.add(new Expression("uid", "=", uid));
		return findByCriteria(exprList, pc);
	}

	// ��ѯ����
	@Override
	public PageBean<Order> findAll(int pc) throws ClassNotFoundException,
			SQLException {
		List<Expression> exprList = new ArrayList<Expression>();
		return findByCriteria(exprList, pc);
	}

	// ��״̬��ѯ
	@Override
	public PageBean<Order> findByStatus(int status, int pc)
			throws ClassNotFoundException, SQLException {
		List<Expression> exprList = new ArrayList<Expression>();
		exprList.add(new Expression("status", "=", status));
		return findByCriteria(exprList, pc);
	}

	// ���ո���������ѯ
	@Override
	public PageBean<Order> findByCriteria(List<Expression> exprList, int pc)
			throws SQLException, ClassNotFoundException {

		// 1. �õ�ps 2. �õ�tr 3. �õ�beanList 4. ����PageBean������

		// 1. �õ�ps
		int ps = PageContant.ORDER_PAGE_SIZE;// ÿҳ��¼��
		
		// 2. ͨ��exprList������where�Ӿ�
		StringBuilder whereSql = new StringBuilder(" where 1=1");
		List<Object> params = new ArrayList<Object>();// SQL�����ʺţ����Ƕ�Ӧ�ʺŵ�ֵ
		for (Expression expr : exprList) {
			/*
			 * ���һ�������ϣ�
			 * 1) ��and��ͷ 
			 * 2) ���������� 
			 * 3) �������������������=��!=��>��< ... is null��is nullû��ֵ 
			 * 4) �����������is null����׷���ʺţ�Ȼ������params�����һ���ʺŶ�Ӧ��ֵ
			 */
			whereSql.append(" and ").append(expr.getName()).append(" ")
					.append(expr.getOperator()).append(" ");
			// where 1=1 and bid = ?
			if (!expr.getOperator().equals("is null")) {
				whereSql.append("?");
				params.add(expr.getValue());
			}
		}

		// 3. �ܼ�¼��
		String sql = "select count(*) from userorder" + whereSql;
		Number number = (Number) qr.query(sql, new ScalarHandler(),
				params.toArray());
		int tr = number.intValue();// �õ����ܼ�¼��
		
		// 4. �õ�beanList������ǰҳ��¼
		sql = "select * from userorder" + whereSql
				+ " userorder by ordertime desc limit ?,?";
		params.add((pc - 1) * ps);// ��ǰҳ���м�¼���±�
		params.add(ps);// һ����ѯ���У�����ÿҳ��¼��

		List<Order> beanList = qr.query(sql, new BeanListHandler<Order>(
				Order.class), params.toArray());
		// ��Ȼ�Ѿ���ȡ���еĶ�������ÿ�������в�û�ж�����Ŀ��
		// ����ÿ��������Ϊ������������ж�����Ŀ
		for (Order order : beanList) {
			itemDao.loadOrderItem(order);
		}

		/*
		 * 5. ����PageBean�����ò���
		 */
		PageBean<Order> pb = new PageBean<Order>();
		/*
		 * ����PageBeanû��url�����������Servlet���
		 */
		pb.setBeanList(beanList);
		pb.setPc(pc);
		pb.setPs(ps);
		pb.setTr(tr);

		return pb;
	}

	@Override
	public List<Order> getOrderByUserId(int userid) throws SQLException,
			ClassNotFoundException {
		
		List<Order> orders=new ArrayList<Order>();
		Connection conn=DBUtil.getConnection();
		String sql="select * from USERORDER where UID=? ";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, userid);
		ResultSet rs=ps.executeQuery();

		while(rs.next()){
			Order order=new Order();
			order.setOid(rs.getInt(1));
			order.setOrdertime(rs.getDate(2));
			order.setTotal(rs.getInt(3));
			order.setStatus(rs.getInt(4));
			order.setAddress(rs.getString(5));
			order.setUid(rs.getInt(6));
			order.setReceiver(rs.getString(7));
			order.setRphone(rs.getString(8));
			orders.add(order);
			
		}
		
		return orders;
	}

	@Override
	public void updateorder(Order order) throws SQLException,
			ClassNotFoundException {

		
		
	
			Connection conn=null;
			PreparedStatement pst=null;
			try {
				conn=DBUtil.getConnection();
				//String sql="update book set ordertime='sysdate',total=?,status=?,address=?,uid=?,receive=?,rphone=? where bid=?";
				String sql="update book set ordertime=?,total=?,status=?,address=?,uid=?,receive=?,rphone=? where bid=?";
				pst=conn.prepareStatement(sql);
				pst.setDate(1, order.getOrdertime());
				pst.setDouble(2, order.getTotal());
				pst.setInt(3, order.getStatus());
				pst.setString(4, order.getAddress());
				pst.setInt(5, order.getUid());
				pst.setString(6, order.getReceiver());
				pst.setString(7, order.getRphone());
				pst.setInt(8,order.getOid());
				
				pst.executeUpdate();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				DBUtil.getClose(conn, pst, null);
			}
			
			
		}

	@Override
	public int getorderid() throws SQLException, ClassNotFoundException {
		
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		int xvleizhi=0;
		try {
			conn=DBUtil.getConnection();
			String sql = "SELECT SE_5.NEXTVAL FROM DUAL";
		
			pst=conn.prepareStatement(sql);
			
			rs=pst.executeQuery();
			
			if(rs.next()){
				xvleizhi=rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.getClose(conn, pst, null);
		}
		return xvleizhi-1;
	}

	@Override
	public void insertorderitembyorderid(Order order) throws SQLException,
			ClassNotFoundException {

//		String sql = "insert into orderitem values(SE_6.nextval,?,?,?,?,?,?,?)";
//		int len = order.getOrderitemList().size();
//		Object[][] objs = new Object[len][];
//		for (int i = 0; i < len; i++) {
//			OrderItem item = order.getOrderitemList().get(i);
//			
//			System.out.println(item.getQuantity()+"q");
//			System.out.println(item.getSubtotal()+"s");
//			System.out.println(item.getBook().getBid()+"bid");
//			System.out.println(order.getOid()+"oid");
//			
//			objs[i] = new Object[] { 
//					item.getQuantity(),
//					item.getSubtotal(), 
//					item.getBook().getBid(),
//					item.getBook().getBname(),
//					order.getOid() };
//		}
//		qr.batch(sql, objs);
		
		Connection conn=null;
		PreparedStatement pst=null;
		
		
		List<OrderItem> orderitems=order.getOrderitemList();
		
		for (OrderItem orderItem : orderitems) {
			
			try {
				conn=DBUtil.getConnection();
				String sql = "insert into ORDERITEM values(SE_6.nextval,?,?,?,?)";
			
				pst=conn.prepareStatement(sql);
				
				pst.setInt(1, orderItem.getQuantity());
				pst.setDouble(2, orderItem.getSubtotal());
				pst.setInt(3,orderItem.getBid());
				pst.setInt(4, order.getOid());
				
				
				pst.executeUpdate();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				DBUtil.getClose(conn, pst, null);
			}
			
			
		}
		
		
		
	}
	
	
		
		
	

}
