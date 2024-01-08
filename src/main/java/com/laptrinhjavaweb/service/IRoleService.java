package com.laptrinhjavaweb.service;

import java.util.List;
import java.util.Map;

import com.laptrinhjavaweb.dto.RoleDTO;

public interface IRoleService {

	List<RoleDTO> findAll();
	RoleDTO findById(long id);
	RoleDTO save(RoleDTO roleDTO);
	void delete(long[] ids);
	Map<String, String> findAllRoles();
}
