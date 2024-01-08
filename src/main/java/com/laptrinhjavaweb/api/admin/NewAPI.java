package com.laptrinhjavaweb.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.dto.NewDTO;
import com.laptrinhjavaweb.service.INewService;

@RestController(value = "NewAPIOfAdmin")
public class NewAPI {

	@Autowired
	private INewService newService;
	
	@PostMapping(value = "/api/new")
	public NewDTO createNew(@RequestBody NewDTO model) {
		return newService.save(model);
	}
	
	@PutMapping(value = "/api/new")
	public NewDTO updateNew(@RequestBody NewDTO model) {
		return newService.save(model);
	}
	
	@DeleteMapping(value = "/api/new")
	public void deleteNew(@RequestBody long[] ids) {
		newService.delete(ids);
	}	
}
