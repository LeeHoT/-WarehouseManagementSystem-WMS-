package com.demo.service;

import java.sql.SQLException;

import com.dhee.dto.UsersDto;

public interface UsersService {
	public UsersDto login(Integer userdId,String password) throws SQLException;

}
