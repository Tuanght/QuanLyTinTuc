package com.laptrinhjavaweb.converter;

import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.RoleDTO;
import com.laptrinhjavaweb.entity.RoleEntity;

@Component
public class RoleConverter {
	
	public RoleDTO toDTO(RoleEntity entity) {
		RoleDTO dto = new RoleDTO();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setCode(entity.getCode());
		return dto;
	}

	public RoleEntity toEntity(RoleDTO dto) {
		RoleEntity entity = new RoleEntity();
		entity.setName(dto.getName());
		entity.setCode(dto.getCode());
		return entity;
	}
	
	public RoleEntity toEntity(RoleDTO dto, RoleEntity entity) {
		entity.setName(dto.getName());
		entity.setCode(dto.getCode());
		return entity;
	}
}