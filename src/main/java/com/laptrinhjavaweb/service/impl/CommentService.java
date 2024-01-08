package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.converter.CommentConverter;
import com.laptrinhjavaweb.dto.CommentDTO;
import com.laptrinhjavaweb.entity.CommentEntity;
import com.laptrinhjavaweb.entity.NewEntity;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.repository.CommentRepository;
import com.laptrinhjavaweb.repository.NewRepository;
import com.laptrinhjavaweb.repository.UserRepository;
import com.laptrinhjavaweb.service.ICommentService;

@Service
public class CommentService implements ICommentService {

	@Autowired
	private CommentRepository commentRepository;

	@Autowired
	private NewRepository newRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CommentConverter commentConverter;

	@Override
	public List<CommentDTO> findAll() {
		List<CommentDTO> models = new ArrayList<>();
		List<CommentEntity> entities = commentRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
		for(CommentEntity item : entities) {
			CommentDTO dto = commentConverter.toDTO(item);
			models.add(dto);
		}
		return models;
	}

	@Override
	public CommentDTO findOneById(long id) {
		CommentEntity entity = commentRepository.findOneById(id);
		return commentConverter.toDTO(entity);
	}

	@Override
	public CommentDTO save(CommentDTO commentDTO) {
		CommentEntity commentEntity = new CommentEntity();
		if (commentDTO.getId() != null) {
			CommentEntity oldCommentEntity = commentRepository.findOneById(commentDTO.getId());
			commentEntity = commentConverter.toEntity(commentDTO,oldCommentEntity);
		}  else {
			commentEntity = commentConverter.toEntity(commentDTO);
		}
		UserEntity user = userRepository.findOneByUserName(commentDTO.getUserName());
		NewEntity news = newRepository.findOneByTitle(commentDTO.getTitle());
		commentEntity.setUser(user);
		commentEntity.setNews(news);
		commentEntity = commentRepository.save(commentEntity);
		return commentConverter.toDTO(commentEntity);
	}

	@Override
	public void delete(long[] ids) {
		for(long item: ids) {
			commentRepository.deleteById(item);
		}
	}

	@Override
	public List<CommentDTO> findAllByNewId(long newId) {
		List<CommentDTO> models = new ArrayList<>();
		List<CommentEntity> entities = commentRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
		for(CommentEntity item : entities)
		{
			CommentDTO dto = commentConverter.toDTO(item);
			if(dto.getNewId() == newId) {
				models.add(dto);
			}
		}
		return models;
	}
	
	
}
