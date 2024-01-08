package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.converter.NewConverter;
import com.laptrinhjavaweb.dto.NewDTO;
import com.laptrinhjavaweb.entity.CategoryEntity;
import com.laptrinhjavaweb.entity.NewEntity;
import com.laptrinhjavaweb.repository.CategoryRepository;
import com.laptrinhjavaweb.repository.NewRepository;
import com.laptrinhjavaweb.service.INewService;

@Service
public class NewService implements INewService{

	@Autowired
	private NewRepository newRepository;

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private NewConverter newConverter;
	
	@Override
	public List<NewDTO> findAllByCategoryId(long categoryId) {
		List<NewDTO> models = new ArrayList<>();
		List<NewEntity> entities = newRepository.findAll();
		for(NewEntity item : entities)
		{
			NewDTO dto = newConverter.toDTO(item);
			if(dto.getCategoryId() == categoryId) {
				models.add(dto);
			}
		}
		return models;
	}

	@Override
	public List<NewDTO> findAll() {
		List<NewDTO> models = new ArrayList<>();
		List<NewEntity> entities = newRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
		for(NewEntity item : entities) {
			NewDTO dto = newConverter.toDTO(item);
			models.add(dto);
		}
		return models;
	}

	@Override
	public NewDTO findById(long id) {
		NewEntity entity = newRepository.findOneById(id);
		return newConverter.toDTO(entity);
	}

	@Override
	public NewDTO save(NewDTO newDTO) {
		NewEntity newEntity = new NewEntity();
		if (newDTO.getId() != null) {
			NewEntity oldNewEntity = newRepository.findOneById(newDTO.getId());
			newEntity = newConverter.toEntity(newDTO,oldNewEntity);
		}  else {
			newEntity = newConverter.toEntity(newDTO);
		}
		CategoryEntity category = categoryRepository.findOneByCode(newDTO.getCategoryCode());
		newEntity.setCategory(category);
		newEntity = newRepository.save(newEntity);
		return newConverter.toDTO(newEntity);
	}

	@Override
	public void delete(long[] ids) {
		for(long item: ids) {
			newRepository.deleteById(item);
		}
	}

	@Override
	public Map<String, String> findAllNews() {
		Map<String, String> result = new HashMap<>();
		List<NewEntity> entities = newRepository.findAll();
		for (NewEntity item : entities) {
			result.put(item.getTitle(), item.getTitle());
		}
		return result;
	}
}
