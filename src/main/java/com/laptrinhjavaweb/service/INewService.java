package com.laptrinhjavaweb.service;

import java.util.List;
import java.util.Map;

import com.laptrinhjavaweb.dto.NewDTO;

public interface INewService {

	List<NewDTO> findAllByCategoryId(long categoryId);
	List<NewDTO> findAll();
	NewDTO findById(long id);
	NewDTO save(NewDTO newDTO);
	void delete(long[] ids);
	Map<String, String> findAllNews();
}
