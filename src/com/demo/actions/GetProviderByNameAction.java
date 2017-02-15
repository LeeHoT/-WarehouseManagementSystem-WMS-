package com.demo.actions;

import java.util.List;

import com.demo.serviceImpl.ProviderServiceImpl;
import com.dhee.dto.ProviderDto;
import com.opensymphony.xwork2.ActionSupport;

public class GetProviderByNameAction extends ActionSupport {

	private static final long serialVersionUID = 4366646898219959941L;
	
	private String name;
	private Integer currentPage;
	private Integer rowCount;
	private Integer maxPageNumber;
	private List<ProviderDto> list;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getRowCount() {
		return rowCount;
	}

	public void setRowCount(Integer rowCount) {
		this.rowCount = rowCount;
	}

	public Integer getMaxPageNumber() {
		return maxPageNumber;
	}

	public void setMaxPageNumber(Integer maxPageNumber) {
		this.maxPageNumber = maxPageNumber;
	}

	public List<ProviderDto> getList() {
		return list;
	}

	public void setList(List<ProviderDto> list) {
		this.list = list;
	}

	@Override
	public String execute() throws Exception {
		rowCount = 5;
		ProviderServiceImpl providerServiceImpl = new ProviderServiceImpl();
		this.list = providerServiceImpl.getProviderByName(currentPage, rowCount, name);
		this.maxPageNumber = providerServiceImpl.getMaxPage(name, rowCount);
		System.out.println(list.size());
		return "success";
	}

}
