package com.bookmall.dao;

import java.sql.SQLException;
import java.util.List;

import com.bookmall.bean.Expression;
import com.bookmall.bean.Order;
import com.bookmall.bean.PageBean;

public interface OrderDao {
	// ���ɶ�����ͨ�����ﳵ�й�ѡ����Ŀ�����ɶ�����
	// �ҵĶ�������ʾ��ǰ�û������ж�����ÿ�������������Ķ�����ĿҲ��Ҫ��ʾ��
	// ����֧����ʹ���ױ��ĵ�����֧��ƽ̨��ɣ��ԡ�����֧���������Ҳ��һ����ս��
	// ������ϸ����ʾָ����ĳ��������
	// ����ȡ���Ͷ�����ȷ���ջ������������ܶ��ǶԶ���״̬���޸ġ�

	// ��ѯ����״̬
	public int findStatus(int oid) throws SQLException, ClassNotFoundException;

	// �޸Ķ���״̬
	public void updateStatus(int oid, int status) throws ClassNotFoundException, SQLException;

	// ���ض���
	public Order load(int oid) throws ClassNotFoundException, SQLException;

	// ���ɶ���
	public void add(Order order) throws ClassNotFoundException, SQLException;

	// ���û���ѯ����
	public PageBean<Order> findByUser(int uid, int pc) throws ClassNotFoundException, SQLException;

	// ��ѯ����
	public PageBean<Order> findAll(int pc) throws ClassNotFoundException, SQLException;

	// ��״̬��ѯ
	public PageBean<Order> findByStatus(int status, int pc) throws ClassNotFoundException, SQLException;

	// ���ո���������ѯ
	public PageBean<Order> findByCriteria(List<Expression> exprList, int pc) throws SQLException, ClassNotFoundException;
	
	public List<Order> getOrderByUserId(int userid)throws SQLException, ClassNotFoundException;
	
	
	public void updateorder(Order order) throws SQLException,ClassNotFoundException ;
	
	
	public int getorderid()throws SQLException,ClassNotFoundException ;
	
	public void insertorderitembyorderid(Order order)throws SQLException,ClassNotFoundException ;
		
		
	
}
