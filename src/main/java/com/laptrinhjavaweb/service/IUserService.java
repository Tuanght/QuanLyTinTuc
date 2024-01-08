package com.laptrinhjavaweb.service;

import java.util.List;
import java.util.Map;

import com.laptrinhjavaweb.dto.UserDTO;

public interface IUserService {

	UserDTO findOneByUserName(String userName);
	List<UserDTO> findAll();
	UserDTO findOneById(long id);
	UserDTO save(UserDTO userDTO);
	void delete(long[] ids);
	Map<String, String> findAllUsers();
}
