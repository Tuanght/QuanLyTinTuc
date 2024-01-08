package com.laptrinhjavaweb.converter;

import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.CommentDTO;
import com.laptrinhjavaweb.entity.CommentEntity;

@Component
public class CommentConverter {

	public CommentEntity toEntity(CommentDTO dto) {
		CommentEntity entity = new CommentEntity();
		entity.setContent(dto.getContent());
		return entity;
	}
	
	public CommentDTO toDTO(CommentEntity entity) {
		CommentDTO dto = new CommentDTO();
		if(entity.getId() != null) {
			dto.setId(entity.getId());
		}
		dto.setContent(entity.getContent());
		dto.setTitle(entity.getNews().getTitle());
		dto.setNewId(entity.getNews().getId());
		dto.setUserName(entity.getUser().getUserName());
		dto.setUserId(entity.getUser().getId());
		return dto;
	}
	
	public CommentEntity toEntity(CommentDTO dto, CommentEntity entity) {
		entity.setContent(dto.getContent());
		return entity;
	}
}
