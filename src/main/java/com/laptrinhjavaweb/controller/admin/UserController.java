package com.laptrinhjavaweb.controller.admin;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.service.IRoleService;
import com.laptrinhjavaweb.service.IUserService;
import com.laptrinhjavaweb.util.MessageUtil;

@Controller(value = "userControllerOfAdmin")
public class UserController {

	@Autowired
	private IUserService userService;

	@Autowired
	private IRoleService roleService;

	@Autowired
	private MessageUtil messageUtil;

	@GetMapping("/quan-tri/tai-khoan/danh-sach")
	public String showList(Model model, HttpServletRequest request) {
		if(SystemConstant.username == null) {
			return "redirect:/dang-nhap";
		}
		UserDTO user = userService.findOneByUserName(SystemConstant.username);
		if(user.getRoleCode().equals("USER")) {
			return "redirect:/trang-chu";
		}
		model.addAttribute("user", user);
		UserDTO listUser = new UserDTO();
		listUser.setListResult(userService.findAll());
		model.addAttribute("model",listUser);
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			model.addAttribute("message", message.get("message"));
			model.addAttribute("alert", message.get("alert"));
		}
		return "admin/user/list";
	}
	
	@GetMapping("/quan-tri/tai-khoan/chinh-sua")
	public String editNew(@RequestParam(value = "id", required = false) Long id, Model model, HttpServletRequest request) {
		if(SystemConstant.username == null) {
			return "redirect:/dang-nhap";
		}
		UserDTO user = userService.findOneByUserName(SystemConstant.username);
		if(user.getRoleCode().equals("USER")) {
			return "redirect:/trang-chu";
		}
		model.addAttribute("user", user);
		UserDTO users = new UserDTO();
		if (id != null) {
			users = userService.findOneById(id);
		}
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			model.addAttribute("message", message.get("message"));
			model.addAttribute("alert", message.get("alert"));
		}
		model.addAttribute("roles", roleService.findAllRoles());
		model.addAttribute("model", users);
		return "admin/user/edit";
	}
	
}
