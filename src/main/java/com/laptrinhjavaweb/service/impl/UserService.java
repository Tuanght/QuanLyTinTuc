package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.converter.UserConverter;
import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.entity.RoleEntity;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.repository.RoleRepository;
import com.laptrinhjavaweb.repository.UserRepository;
import com.laptrinhjavaweb.service.IUserService;

@Service
public class UserService implements IUserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserConverter userConverter;
	
	@Override
	public UserDTO findOneByUserName(String userName) {
		UserEntity entity = userRepository.findOneByUserName(userName);
		return userConverter.toDTO(entity);
	}

	@Override
	public List<UserDTO> findAll() {
		List<UserDTO> models = new ArrayList<>();
		List<UserEntity> entities = userRepository.findAll();
		for(UserEntity item : entities) {
			UserDTO dto = userConverter.toDTO(item);
			models.add(dto);
		}
		return models;
	}

	@Override
	public UserDTO findOneById(long id) {
		UserEntity entity = userRepository.findOneById(id);
		return userConverter.toDTO(entity);
	}

	@Override
	public UserDTO save(UserDTO userDTO) {
		UserEntity userEntity = new UserEntity();
		if (userDTO.getId() != null) {
			UserEntity oldUserEntity = userRepository.findOneById(userDTO.getId());
			userEntity = userConverter.toEntity(userDTO,oldUserEntity);
		}  else {
			userEntity = userConverter.toEntity(userDTO);
		}
		RoleEntity role = roleRepository.findOneByCode(userDTO.getRoleCode());
		userEntity.setRole(role);
		userEntity = userRepository.save(userEntity);
		return userConverter.toDTO(userEntity);
	}

	@Override
	public void delete(long[] ids) {
		for(long item: ids) {
			userRepository.deleteById(item);
		}
	}

	@Override
	public Map<String, String> findAllUsers() {
		Map<String, String> result = new HashMap<>();
		List<UserEntity> entities = userRepository.findAll();
		for (UserEntity item : entities) {
			result.put(item.getUserName(), item.getUserName());
		}
		return result;
	}
	
	
}
