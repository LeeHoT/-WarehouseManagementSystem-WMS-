package com.demo.actions;

import com.demo.serviceImpl.ProviderServiceImpl;
import com.dhee.dto.ProviderDto;
import com.opensymphony.xwork2.ActionSupport;

public class ModifyProviderAction extends ActionSupport {

	private static final long serialVersionUID = 288482502829444192L;
	private ProviderDto providerDto;

	public ProviderDto getProviderDto() {
		return providerDto;
	}

	public void setProviderDto(ProviderDto providerDto) {
		this.providerDto = providerDto;
	}

	@Override
	public String execute() throws Exception {
		try {
			ProviderServiceImpl providerServiceImpl = new ProviderServiceImpl();
			boolean result = providerServiceImpl.modifyProvider(providerDto);
			if (result) {
				System.out.println("修改供应商信息成功");
				return "success";
			}
			return "input";
		} catch (Exception e) {
			System.out.println("修改供应商信息失败");
			return "input";
		}
	}
}
