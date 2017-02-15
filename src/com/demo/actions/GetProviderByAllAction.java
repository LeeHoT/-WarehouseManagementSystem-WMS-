package com.demo.actions;

import java.util.List;

import com.demo.serviceImpl.ProviderServiceImpl;
import com.dhee.dto.ProviderDto;
import com.opensymphony.xwork2.ActionSupport;

public class GetProviderByAllAction extends ActionSupport {

	private static final long serialVersionUID = -5655948208033942124L;

	private List<ProviderDto> list;
	private ProviderDto providerDto;
	private Integer currentPage;
	private Integer rowCount;
	private Integer maxPageNumber;

	public List<ProviderDto> getList() {
		return list;
	}

	public void setList(List<ProviderDto> list) {
		this.list = list;
	}

	public ProviderDto getProviderDto() {
		return providerDto;
	}

	public void setProviderDto(ProviderDto providerDto) {
		this.providerDto = providerDto;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getMaxPageNumber() {
		return maxPageNumber;
	}

	public void setMaxPageNumber(Integer maxPageNumber) {
		this.maxPageNumber = maxPageNumber;
	}

	@Override
	public String execute() throws Exception {
		rowCount = 5;
		System.out.println(providerDto.getName());
		System.out.println(providerDto.getId());
		System.out.println(providerDto.getAddress());
		ProviderServiceImpl providerServiceImpl  = new ProviderServiceImpl();
		this.list = providerServiceImpl.getProviderByAll(currentPage, rowCount, providerDto);
		// this.maxPageNumber = productServiceImpl.getMaxPage(message,
		// rowCount);
		System.out.println(list.size());
		return "success";
	}

}
