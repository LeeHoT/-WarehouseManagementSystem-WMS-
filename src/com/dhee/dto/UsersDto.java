package com.dhee.dto;

import java.io.Serializable;

/**
 * 
 * 用于封装users表中一行用户信息
 * @author leehot
 *
 */
public class UsersDto implements Serializable{
	private static final long serialVersionUID = -4059202353029193836L;
	private Integer USER_ID;// ID
	private String USER_NAME;// 用户名
	private String USER_PASSWORD;// 用户密码

	public Integer getUSER_ID() {
		return USER_ID;
	}

	public void setUSER_ID(Integer uSER_ID) {
		USER_ID = uSER_ID;
	}

	public String getUSER_NAME() {
		return USER_NAME;
	}

	public void setUSER_NAME(String uSER_NAME) {
		USER_NAME = uSER_NAME;
	}

	public String getUSER_PASSWORD() {
		return USER_PASSWORD;
	}

	public void setUSER_PASSWORD(String uSER_PASSWORD) {
		USER_PASSWORD = uSER_PASSWORD;
	}

}
