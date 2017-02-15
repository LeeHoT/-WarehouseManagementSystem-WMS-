package com.demo.actions;

import java.util.List;

import com.demo.serviceImpl.ProviderServiceImpl;
import com.dhee.dto.ProviderDto;
import com.opensymphony.xwork2.ActionSupport;

public class getAllProviderAction extends ActionSupport {

	private static final long serialVersionUID = 2204426907523626242L;
	private List<ProviderDto> list;

	public List<ProviderDto> getList() {
		return list;
	}

	public void setList(List<ProviderDto> list) {
		this.list = list;
	}

	@Override
	public String execute() throws Exception {
		System.out.println("getAllProviderAction.");
		try {
			ProviderServiceImpl providerServiceImpl = new ProviderServiceImpl();
			this.list = providerServiceImpl.getAllProvider();
			System.out.println("getAllProviderAction." + list.size());
			if(list.size()>0){
				return "success";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return "input";
		}
		// TODO Auto-generated method stub
		return "input";
	}
}
