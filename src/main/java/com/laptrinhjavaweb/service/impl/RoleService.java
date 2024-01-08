package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.converter.RoleConverter;
import com.laptrinhjavaweb.dto.RoleDTO;
import com.laptrinhjavaweb.entity.RoleEntity;
import com.laptrinhjavaweb.repository.RoleRepository;
import com.laptrinhjavaweb.service.IRoleService;

@Service
public class RoleService implements IRoleService{
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private RoleConverter roleConverter;
	
	@Override
	public Map<String, String> findAllRoles() {
		Map<String, String> result = new HashMap<>();
		List<RoleEntity> entities = roleRepository.findAll();
		for (RoleEntity item : entities) {
			result.put(item.getCode(), item.getName());
		}
		return result;
	}

	@Override
	public List<RoleDTO> findAll() {
		List<RoleDTO> models = new ArrayList<>();
		List<RoleEntity> entities = roleRepository.findAll();
		for(RoleEntity item : entities) {
			RoleDTO dto = roleConverter.toDTO(item);
			models.add(dto);
		}
		return models;
	}

	@Override
	public RoleDTO findById(long id) {
		RoleEntity entity = roleRepository.findOneById(id);
		return roleConverter.toDTO(entity);
	}

	@Override
	public RoleDTO save(RoleDTO roleDTO) {
		RoleEntity roleEntity = new RoleEntity();
		if (roleDTO.getId() != null) {
			RoleEntity oldRoleEntity = roleRepository.findOneById(roleDTO.getId());
			roleEntity = roleConverter.toEntity(roleDTO,oldRoleEntity);
		}  else {
			roleEntity = roleConverter.toEntity(roleDTO);
		}
		roleEntity = roleRepository.save(roleEntity);
		return roleConverter.toDTO(roleEntity);
	}

	@Override
	public void delete(long[] ids) {
		for(long item: ids) {
			roleRepository.deleteById(item);
		}
	}

}
