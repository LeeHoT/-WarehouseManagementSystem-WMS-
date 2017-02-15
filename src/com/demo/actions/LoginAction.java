 package com.demo.actions;

import java.sql.SQLException;

import com.demo.serviceImpl.UsersServiceImpl;
import com.dhee.dto.UsersDto;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

	private static final long serialVersionUID = 9043023563693462705L;
	private Integer userId;
	private String userPassword;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return super.execute();
	}

	@Override
	public void validate() {
		System.out.println(userId + userPassword);
		if (this.userId == null) {
			this.addFieldError("IdNull", this.getText("index_id_null"));
		}
		if (this.userPassword == null || this.userPassword.trim().equals("")) {
			this.addFieldError("PasswordNull", this.getText("index_password_null"));
			return;
		}
	}

	public String login() throws SQLException {
		UsersDto userDto = null;
		try {
			// 根据请求选择合适模型层组件
			UsersServiceImpl usersServiceImpl = new UsersServiceImpl();
			// 将试图层的数据传递到模型层中
			userDto = usersServiceImpl.login(userId, userPassword);
			// 根据模型层的结果，控制试图层显示"正确"/"错误"
			if (userDto != null) {
				System.out.println("id为" + userId + "的用户登录成功");
				return "success";
			}
			return "input";
		} catch (Exception e) {
			System.out.println("登录错误");
			return "input";
		}

	}

}
