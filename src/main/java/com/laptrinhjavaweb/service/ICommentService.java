package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.dto.CommentDTO;

public interface ICommentService {

	List<CommentDTO> findAll();
	CommentDTO findOneById(long id);
	CommentDTO save(CommentDTO commentDTO);
	void delete(long[] ids);
	List<CommentDTO> findAllByNewId(long newId);
}
