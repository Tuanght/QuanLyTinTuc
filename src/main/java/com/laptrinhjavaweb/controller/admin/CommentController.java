package com.laptrinhjavaweb.controller.admin;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.dto.CommentDTO;
import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.service.ICommentService;
import com.laptrinhjavaweb.service.INewService;
import com.laptrinhjavaweb.service.IUserService;
import com.laptrinhjavaweb.util.MessageUtil;

@Controller(value = "commentControllerOfAdmin")
public class CommentController {

	@Autowired
	private ICommentService commentService;

	@Autowired
	private INewService newService;

	@Autowired
	private MessageUtil messageUtil;

	@Autowired
	private IUserService userService;
	
	@GetMapping("/quan-tri/binh-luan/danh-sach")
	public String showList(Model model, HttpServletRequest request) {
		if(SystemConstant.username == null) {
			return "redirect:/dang-nhap";
		}
		UserDTO user = userService.findOneByUserName(SystemConstant.username);
		if(user.getRoleCode().equals("USER")) {
			return "redirect:/trang-chu";
		}
		model.addAttribute("user", user);
		CommentDTO listComment = new CommentDTO();
		listComment.setListResult(commentService.findAll());
		model.addAttribute("model",listComment);
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			model.addAttribute("message", message.get("message"));
			model.addAttribute("alert", message.get("alert"));
		}
		return "admin/comment/list";
	}
	
	@GetMapping("/quan-tri/binh-luan/chinh-sua")
	public String editNew(@RequestParam(value = "id", required = false) Long id, Model model, HttpServletRequest request) {
		if(SystemConstant.username == null) {
			return "redirect:/dang-nhap";
		}
		UserDTO user = userService.findOneByUserName(SystemConstant.username);
		if(user.getRoleCode().equals("USER")) {
			return "redirect:/trang-chu";
		}
		model.addAttribute("user", user);
		CommentDTO comments = new CommentDTO();
		if (id != null) {
			comments = commentService.findOneById(id);
		}
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			model.addAttribute("message", message.get("message"));
			model.addAttribute("alert", message.get("alert"));
		}
		model.addAttribute("news", newService.findAllNews());
		model.addAttribute("users", userService.findAllUsers());
		model.addAttribute("model", comments);
		return "admin/comment/edit";
	}
	
}
