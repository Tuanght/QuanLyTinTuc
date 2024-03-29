package com.laptrinhjavaweb.service;

import java.util.List;
import java.util.Map;

import com.laptrinhjavaweb.dto.CategoryDTO;

public interface ICategoryService {

	List<CategoryDTO> findAll();
	CategoryDTO findById(long id);
	CategoryDTO save(CategoryDTO categoryDTO);
	void delete(long[] ids);
	Map<String, String> findAllCategories();
}
