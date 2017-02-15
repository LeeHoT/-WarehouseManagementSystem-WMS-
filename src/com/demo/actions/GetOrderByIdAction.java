package com.demo.actions;

import java.util.List;

import com.demo.serviceImpl.BillhtServiceImpl;
import com.dhee.dto.BillhtDto;
import com.opensymphony.xwork2.ActionSupport;

public class GetOrderByIdAction extends ActionSupport {

	private static final long serialVersionUID = 3778635116693092797L;
	private List<BillhtDto> list;
	private Integer orderId;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public List<BillhtDto> getList() {
		return list;
	}

	public void setList(List<BillhtDto> list) {
		this.list = list;
	}

	@Override
	public String execute() throws Exception {
		if(orderId==null||orderId.equals("")){
			return "input";
		}
		BillhtServiceImpl billhtServiceImpl = new BillhtServiceImpl();
		list = billhtServiceImpl.getOrderById(orderId);
		/**
		 * 此处可通过迭代，将providerId等list中关联其他表的列中的信息保存到providerName中
		 * 然后通过传递String[]在Dao中，将取得的providerName保存到providerName[i]中
		 * 然后再本action通过String[]数据接收返回的数据
		 * 
		 * 而在Dao和Service中则顺次返回String[]数据
		 */
		if (list.size() <= 0) {
			return "input";
		}
		// for (int i = 0; i < list.size(); i++) {
		// providerName[i] =
		// providerServiceImpl.getProviderNameById(list.get(i).getProvider_id());
		// System.out.println("第" + i + "个供应商名字：" + providerName[i]);
		// price[i] = billhtServiceImpl.getTotalPriceById(list.get(i).getId());
		// creator[i] =
		// billhtServiceImpl.getCreatorById(list.get(i).getCreator());
		// payment[i] =
		// billhtServiceImpl.getPaymentById(list.get(i).getPayment());
		// status[i] = billhtServiceImpl.getStatusById(list.get(i).getStatus());
		// }
		return "success";
	}

}
