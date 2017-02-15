package com.demo.serviceImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.demo.dao.BillhtDao;
import com.demo.dao.ProviderDao;
import com.demo.util.DBUtil;
import com.dhee.dto.BillhtDto;
import com.dhee.dto.DetailDto;

public class BillhtServiceImpl {

	BillhtDao billhtDao = null;

	public BillhtServiceImpl() {
		billhtDao = new BillhtDao();
	}

	//获取订单详情
	public List<DetailDto> getOrderDetail(int id) throws SQLException{
		Connection conn = null;
		List<DetailDto> list = null;
		try {
			conn = DBUtil.getConnection();
			list = billhtDao.getOrdertDetail(conn, id);
		} finally {
			if(conn!=null){
				conn.close();
			}
		}
		return list;
	}
	
	//删除订单
	public boolean deleteOrderAndDetail(int id) throws SQLException{
		Connection conn = null;
		boolean flag = false;
		try {
			conn = DBUtil.getConnection();
			flag = billhtDao.deleteOrderAndDetail(conn, id);
		} finally {
			if(conn!=null){
				conn.close();
			}
		}
		return flag;
	}
	
	//根据订单号获取订单总价
	public Double getTotalPriceById(int orderId) throws SQLException{
		Connection conn = null;
		Double price = null;
		try {
			conn = DBUtil.getConnection();
			price = billhtDao.getTotalPrice(conn, orderId);
					
		} finally {
			if(conn!=null){
				conn.close();
			}
		}
		return price;
	}
	
	//根据Id获取支付方式
	public String getPaymentById(int paymentId) throws SQLException{
		Connection conn = null;
		String paymentName = null;
		try {
			conn = DBUtil.getConnection();
			paymentName = billhtDao.getPaymentNameById(conn, paymentId);
		} finally {
			if(conn!=null){
				conn.close();
			}
		}
		return paymentName;
	}
	
	//根据ID获取状态信息
	public String getStatusById(int statusId) throws SQLException{
		Connection conn = null;
		String statusName = null;
		try {
			conn = DBUtil.getConnection();
			statusName = billhtDao.getStatusNameById(conn, statusId);
		} finally {
			if(conn!=null){
				conn.close();
			}
		}
		return statusName;
	}
	
	//根据Id获取创建者名
	public String getCreatorById(int creatorId) throws SQLException{
		Connection conn = null;
		String creatorName = null;
		try {
			conn = DBUtil.getConnection();
			creatorName = billhtDao.getCreatorNameById(conn, creatorId);
		} finally {
			if(conn!=null){
				conn.close();
			}
		}
		return creatorName;
	}
	//获取所有订单信息
	public List<BillhtDto> getAllOrder() throws SQLException{
		Connection conn= null;
		List<BillhtDto> list = null;
		try {
			conn = DBUtil.getConnection();
			list = billhtDao.getAllOrder(conn);
		} finally {
			if(conn!=null){
				conn.close();
			}
		}
		return list;
		
		
	}
	
	//根据订单号获取订单
	public List<BillhtDto> getOrderById(int id) throws SQLException{
		Connection conn  = null;
		List<BillhtDto> list  = null;
		try {
			conn = DBUtil.getConnection();
			list = billhtDao.getOrderById(conn, id);
		} finally {
			if(conn!=null){
				conn.close();
			}
		}
		return list;
	}
	
	// 添加新订单信息进入ORDERS表，，并返回新订单ID
	public boolean addOrders(BillhtDto billhtDto, String providerName, String creator, String payment, String[] check,
			String[] price, String[] quantity,String[] id) throws SQLException, ParseException {
		Connection conn = null;
		int providerId = 0;
		int creatorId = 0;
		int paymentId = 0;
		int flag = 0;
		boolean dflag = false;
		ProviderDao providerDao = new ProviderDao();
		try {
			conn = DBUtil.getConnection();
			// 获取供应商的ID
			conn.setAutoCommit(false);
			providerId = providerDao.getProviderIdByName(conn, providerName);
			if (providerId == 0) {
				return dflag;
			}
			System.out.println("providerId" + providerId);

			// 获取订支付方式的ID
			paymentId = billhtDao.getPaymentIdByName(conn, payment);
			if (paymentId == 0) {
				return dflag;
			}
			System.out.println("paymentId" + paymentId);
			// 获取创建者的ID
			creatorId = billhtDao.getCreatorIdByName(conn, creator);
			if (creatorId == 0) {
				return dflag;
			}
			System.out.println("creatorId" + creatorId);
			billhtDto.setCreator(creatorId);
			billhtDto.setPayment(paymentId);
			billhtDto.setProvider_id(providerId);

			// 获取订单总价
			// price = billhtDao.getOrderTotalPrice(temp);
			// 返回生成订单的ID
			flag = billhtDao.addOrders(conn, billhtDto);

			if (flag > 0) {
				dflag = billhtDao.addDetailOrder(conn, flag, check, price, quantity,id);
				if (dflag) {
					conn.commit();
					return dflag;
				}
			}
			conn.rollback();
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
		return dflag;
	}

}
