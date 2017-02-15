package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.demo.util.DateFormatUtil;
import com.dhee.dto.BillhtDto;
import com.dhee.dto.DetailDto;
import com.dhee.dto.PaymentDto;
import com.dhee.dto.ProductDto;
import com.dhee.dto.ProviderDto;
import com.dhee.dto.StatusDto;
import com.dhee.dto.UsersDto;

/**
 * 
 * @author 李慧婷
 *
 */
public class BillhtDao {

	// 获取订单详情
	public List<DetailDto> getOrdertDetail(Connection conn, int id) throws SQLException {
		PreparedStatement ps = null;
		ResultSet ret = null;
		DetailDto detailDto = null;
		List<DetailDto> list = null;
		String sql = "SELECT ORDER_ID,PRODUCT_ID,PRODUCT.NAME,PRODUCT_QUANTITY,PRODUCT_PRICE,PRODUCT_QUANTITY*PRODUCT_PRICE AS TOTALPRICE FROM DETAIL,PRODUCT WHERE PRODUCT.ID = DETAIL.PRODUCT_ID AND ORDER_ID = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ret = ps.executeQuery();
			list = new ArrayList<DetailDto>();
			while (ret.next()) {
				detailDto = new DetailDto();
				detailDto.setOrder_id(ret.getInt("ORDER_ID"));
				detailDto.setProduct_id(ret.getInt("PRODUCT_ID"));

				ProductDto productDto = new ProductDto();
				productDto.setName(ret.getString("NAME"));
				System.out.println("........."+productDto.getName());
				detailDto.setProductDto(productDto);
				detailDto.setProduct_price(ret.getInt("PRODUCT_PRICE"));
				detailDto.setProduct_quantity(ret.getInt("PRODUCT_QUANTITY"));
				detailDto.setTotalPrice(ret.getInt("TOTALPRICE"));
				list.add(detailDto);
			}
		} finally {
			if (ps != null) {
				ps.close();
			}
			if (ret != null) {
				ret.close();
			}
		}
		return list;
	}

	// 删除订单信息
	@SuppressWarnings("resource")
	public boolean deleteOrderAndDetail(Connection conn, int id) throws SQLException {
		PreparedStatement ps = null;
		int rows = 0;
		try {
			String sql = "DELETE FROM DETAIL WHERE EXISTS " + "(SELECT * FROM ORDERS WHERE DETAIL.ORDER_ID = ?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rows = ps.executeUpdate();
			if (rows > 0) {
				String dsql = "DELETE FROM ORDERS WHERE ID = ?";
				ps = conn.prepareStatement(dsql);
				ps.setInt(1, id);
				rows = ps.executeUpdate();
				if (rows > 0) {
					return true;
				}
				return false;
			}
			return false;
		} finally {
			if (ps != null) {
				ps.close();
			}
		}
	}

	// 获取所有订单信息
	public List<BillhtDto> getAllOrder(Connection conn) throws SQLException {
		PreparedStatement ps = null;
		ResultSet ret = null;
		List<BillhtDto> list = null;
		BillhtDto billhtDto = null;
		String sql = "SELECT ORDERS.ID,ORDERS.BUYER,ORDERS.REVIEWER,ORDERS.PRODATE,"
				+ "PROVIDER.NAME,PAYMENT_DICT.PAYMENT,USERS.USER_NAME,ORDER_STATUS_DICT.ORDER_STATUS "
				+ "FROM ORDERS,PROVIDER,ORDER_STATUS_DICT,USERS,PAYMENT_DICT WHERE "
				+ "ORDERS.PROVIDER_ID = provider.id AND " + "ORDERS.PAYMENT = PAYMENT_DICT.ID AND "
				+ "ORDERS.STATUS = ORDER_STATUS_DICT.ID " + "AND ORDERS.CREATOR = USERS.USER_ID";
		try {
			ps = conn.prepareStatement(sql);
			ret = ps.executeQuery();
			list = new ArrayList<BillhtDto>();
			while (ret.next()) {
				billhtDto = new BillhtDto();
				billhtDto.setId(ret.getInt("ID"));

				StatusDto statusDto = new StatusDto();
				statusDto.setOrder_status(ret.getString("ORDER_STATUS"));
				PaymentDto paymentDto = new PaymentDto();
				paymentDto.setPayment(ret.getString("PAYMENT"));
				ProviderDto providerDto = new ProviderDto();
				providerDto.setName(ret.getString("NAME"));
				UsersDto usersDto = new UsersDto();
				usersDto.setUSER_NAME(ret.getString("USER_NAME"));

				billhtDto.setStatusDto(statusDto);
				billhtDto.setProvider(providerDto);
				billhtDto.setPaymentDto(paymentDto);
				billhtDto.setUsersDto(usersDto);
				// billhtDto.setId(ret.getInt("PROVIDER_ID"));
				billhtDto.setBuyer(ret.getString("BUYER"));
				// billhtDto.setId(ret.getInt("PAYMENT"));
				billhtDto.setReviewer(ret.getString("REVIEWER"));
				// billhtDto.setCreator(ret.getInt("CREATOR"));
				billhtDto.setProDate(ret.getString("PRODATE"));
				// billhtDto.setStatus(ret.getInt("STATUS"));
				String ssql = "SELECT SUM(PRODUCT_QUANTITY*PRODUCT_PRICE) AS SUM FROM DETAIL,ORDERS WHERE ORDER_ID = ?";
				ResultSet rs = null;
				ps = conn.prepareStatement(ssql);
				ps.setString(1, ret.getString("ID"));
				rs = ps.executeQuery();
				if (rs.next()) {
					billhtDto.setPrice(Double.parseDouble(rs.getString("SUM")));
				}
				list.add(billhtDto);
			}

		} finally {
			if (ps != null) {
				ps.close();
			}
			if (ret != null) {
				ret.close();
			}
		}
		return list;
	}

	// 根据订单编号获取订单信息
	public List<BillhtDto> getOrderById(Connection conn, int id) throws SQLException {
		PreparedStatement ps = null;
		ResultSet ret = null;
		List<BillhtDto> list = null;
		BillhtDto billhtDto = null;
		String sql = "SELECT ORDERS.ID,ORDERS.BUYER,ORDERS.REVIEWER,ORDERS.PRODATE,"
				+ "PROVIDER.NAME,PAYMENT_DICT.PAYMENT,USERS.USER_NAME,ORDER_STATUS_DICT.ORDER_STATUS "
				+ "FROM ORDERS,PROVIDER,ORDER_STATUS_DICT,USERS,PAYMENT_DICT WHERE "
				+ "ORDERS.PROVIDER_ID = provider.id AND " + "ORDERS.PAYMENT = PAYMENT_DICT.ID AND "
				+ "ORDERS.STATUS = ORDER_STATUS_DICT.ID " + "AND ORDERS.CREATOR = USERS.USER_ID AND "
				+ "ORDERS.ID LIKE ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + id + "%");
			ret = ps.executeQuery();
			list = new ArrayList<BillhtDto>();
			while (ret.next()) {
				billhtDto = new BillhtDto();
				billhtDto.setId(ret.getInt("ID"));

				StatusDto statusDto = new StatusDto();
				statusDto.setOrder_status(ret.getString("ORDER_STATUS"));
				PaymentDto paymentDto = new PaymentDto();
				paymentDto.setPayment(ret.getString("PAYMENT"));
				ProviderDto providerDto = new ProviderDto();
				providerDto.setName(ret.getString("NAME"));
				UsersDto usersDto = new UsersDto();
				usersDto.setUSER_NAME(ret.getString("USER_NAME"));

				billhtDto.setStatusDto(statusDto);
				billhtDto.setProvider(providerDto);
				billhtDto.setPaymentDto(paymentDto);
				billhtDto.setUsersDto(usersDto);
				// billhtDto.setId(ret.getInt("PROVIDER_ID"));
				billhtDto.setBuyer(ret.getString("BUYER"));
				// billhtDto.setId(ret.getInt("PAYMENT"));
				billhtDto.setReviewer(ret.getString("REVIEWER"));
				// billhtDto.setCreator(ret.getInt("CREATOR"));
				billhtDto.setProDate(ret.getString("PRODATE"));
				// billhtDto.setStatus(ret.getInt("STATUS"));
				String ssql = "SELECT SUM(PRODUCT_QUANTITY*PRODUCT_PRICE) AS SUM FROM DETAIL,ORDERS WHERE ORDER_ID = ?";
				ResultSet rs = null;
				ps = conn.prepareStatement(ssql);
				ps.setString(1, ret.getString("ID"));
				rs = ps.executeQuery();
				if (rs.next()) {
					billhtDto.setPrice(Double.parseDouble(rs.getString("SUM")));
				}
				list.add(billhtDto);
			}

		} finally {
			if (ps != null) {
				ps.close();
			}
			if (ret != null) {
				ret.close();
			}
		}
		return list;
	}

	@SuppressWarnings("resource")
	public int addOrders(Connection conn, BillhtDto billhtDto) throws SQLException, ParseException {
		int flag = 0;
		PreparedStatement ps = null;
		ResultSet ret = null;
		String sql = "INSERT INTO ORDERS(ID,PROVIDER_ID,BUYER,PAYMENT,REVIEWER,CREATOR,PRODATE,STATUS) VALUES(ORDERS_ID_SEQ.NEXTVAL,?,?,?,?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			System.out.println(
					billhtDto.getProvider_id() + "aaaaaaa" + billhtDto.getPayment() + "dddd" + billhtDto.getCreator());
			ps.setInt(1, billhtDto.getProvider_id());
			ps.setString(2, billhtDto.getBuyer());
			ps.setInt(3, billhtDto.getPayment());
			ps.setString(4, billhtDto.getReviewer());
			ps.setInt(5, billhtDto.getCreator());
			System.out.println(billhtDto.getProDate());
			ps.setDate(6, DateFormatUtil.dateFormat(billhtDto.getProDate()));

			// 表示未处理
			ps.setInt(7, 1);
			int row = ps.executeUpdate();
			System.out.println("增加订单函数" + row);
			String ssql = "SELECT ID FROM ORDERS ORDER BY ID DESC";
			ps = conn.prepareStatement(ssql);
			ret = ps.executeQuery();
			// 只执行一次，，取得最新的id,即为新加入的
			if (ret.next()) {
				flag = ret.getInt("ID");
			}
			System.out.println("新产品ID: " + flag);
		} finally {
			if (ps != null) {
				ps.close();
			}
		}
		// 返回生成订单的id
		return flag;
	}

	// 根据用户名获取ID
	public int getCreatorIdByName(Connection conn, String creator) throws SQLException {
		PreparedStatement ps = null;
		ResultSet ret = null;
		int creatorId = 0;
		try {
			String sql = "SELECT user_id FROM USERS WHERE USER_NAME = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, creator);
			ret = ps.executeQuery();
			if (ret.next()) {
				creatorId = ret.getInt("user_id");
			}
			System.out.println("creatorId." + creatorId);
		} finally {
			if (ps != null) {
				ps.close();
			}
			if (ret != null) {
				ret.close();
			}
		}
		return creatorId;
	}

	// 根据状态名获取ID
	public int getStatusIdByName(Connection conn, String status) throws SQLException {
		PreparedStatement ps = null;
		ResultSet ret = null;
		int statusId = 0;
		try {
			String sql = "SELECT ID FROM ORDER_STATUS_DICT WHERE ORDER_STATUS = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, status);
			ret = ps.executeQuery();
			if (ret.next()) {
				statusId = ret.getInt("ID");
			}
			System.out.println("statusId ." + statusId);
		} finally {
			if (ps != null) {
				ps.close();
			}
			if (ret != null) {
				ret.close();
			}
		}
		return statusId;
	}

	// 根据支付方式获取ID
	public int getPaymentIdByName(Connection conn, String payment) throws SQLException {
		PreparedStatement ps = null;
		ResultSet ret = null;
		int paymentId = 0;
		try {
			String sql = "SELECT ID FROM payment_dict WHERE payment = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, payment);
			ret = ps.executeQuery();
			if (ret.next()) {
				paymentId = ret.getInt("ID");
			}
			System.out.println("statusId ." + paymentId);
		} finally {
			if (ps != null) {
				ps.close();
			}
			if (ret != null) {
				ret.close();
			}
		}
		return paymentId;
	}

	// 根据ID获取创建者
	public String getCreatorNameById(Connection conn, int createId) throws SQLException {
		PreparedStatement ps = null;
		ResultSet ret = null;
		String creatorName = null;
		try {
			String sql = "SELECT user_name FROM USERS WHERE USER_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, createId);
			ret = ps.executeQuery();
			if (ret.next()) {
				creatorName = ret.getString("user_name");
			}
			System.out.println("creatorName." + creatorName);
		} finally {
			if (ps != null) {
				ps.close();
			}
			if (ret != null) {
				ret.close();
			}
		}
		return creatorName;
	}

	// 根据ID获取status
	public String getStatusNameById(Connection conn, int statusId) throws SQLException {
		PreparedStatement ps = null;
		ResultSet ret = null;
		String statusName = null;
		try {
			String sql = "SELECT order_status FROM ORDER_STATUS_DICT WHERE id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, statusId);
			ret = ps.executeQuery();
			if (ret.next()) {
				statusName = ret.getString("order_status");
			}
			System.out.println("statusName ." + statusName);
		} finally {
			if (ps != null) {
				ps.close();
			}
			if (ret != null) {
				ret.close();
			}
		}
		return statusName;
	}

	// 根据ID获取支付方式
	public String getPaymentNameById(Connection conn, int paymentId) throws SQLException {
		PreparedStatement ps = null;
		ResultSet ret = null;
		String paymentName = null;
		try {
			String sql = "SELECT payment FROM payment_dict WHERE paymentId = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, paymentId);
			ret = ps.executeQuery();
			if (ret.next()) {
				paymentName = ret.getString("payment");
			}
			System.out.println("paymentName ." + paymentName);
		} finally {
			if (ps != null) {
				ps.close();
			}
			if (ret != null) {
				ret.close();
			}
		}
		return paymentName;
	}

	public boolean addDetailOrder(Connection conn, int orderId, String[] check, String[] price, String[] quantity,String[] id)
			throws SQLException {
		PreparedStatement ps = null;
		String sql = "INSERT INTO DETAIL VALUES(?,?,?,?)";
		for (int i = 0; i < check.length; i++) {
			int r = Integer.parseInt(check[i]);
			ps = conn.prepareStatement(sql);
			ps.setInt(1, orderId);
			ps.setInt(2, Integer.parseInt(id[r]));
			ps.setInt(3, Integer.parseInt(quantity[r]));
			ps.setDouble(4, Double.parseDouble(price[r]));
			int row = ps.executeUpdate();
			if (row > 0) {
				System.out.println("插入产品：" + check[i]);
			} else {
				return false;
			}
		}
		return true;
	}

	// 获取订单总价
	public Double getTotalPrice(Connection conn, int orderId) throws SQLException {
		PreparedStatement ps = null;
		ResultSet ret = null;
		// 有问题
		Double sum = 0.00;
		String sql = "SELECT PRODUCT_QUANTITY,PRODUCT_PRICE FROM DETAIL WHERE ORDER_ID = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, orderId);
			ret = ps.executeQuery();
			while (ret.next()) {
				sum = sum + ret.getInt("PRODUCT_QUANTITY") * ret.getDouble("PRODUCT_PRICE");
			}
			System.out.println(sum);
		} finally {
			if (ps != null) {
				ps.close();
			}
			if (ret != null) {
				ret.close();
			}
		}
		return sum;
	}
}
