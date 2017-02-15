package com.demo.actions;

import com.demo.serviceImpl.ProviderServiceImpl;
import com.dhee.dto.ProviderDto;
import com.opensymphony.xwork2.ActionSupport;

public class AddProviderAction extends ActionSupport {
	private static final long serialVersionUID = -8529761266874376103L;
	private ProviderDto providerDto = null;

	public ProviderDto getProviderDto() {
		return providerDto;
	}

	public void setProviderDto(ProviderDto providerDto) {
		this.providerDto = providerDto;
	}

	@Override
	public String execute() throws Exception {
		boolean result = false;
		try {
			ProviderServiceImpl providerServiceImpl = new ProviderServiceImpl();
			result = providerServiceImpl.addProvider(providerDto);
			if (result) {
				System.out.println("插入供应商成功！");
				return "success";
			}
			return "input";
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("插入供应商失败！");
			return "input";
		}
	}
}
