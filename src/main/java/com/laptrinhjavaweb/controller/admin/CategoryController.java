package com.laptrinhjavaweb.controller.admin;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.dto.CategoryDTO;
import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.service.ICategoryService;
import com.laptrinhjavaweb.service.IUserService;
import com.laptrinhjavaweb.util.MessageUtil;

@Controller(value = "categoryControllerOfAdmin")
public class CategoryController {

	@Autowired
	private ICategoryService categoryService;

	@Autowired
	private MessageUtil messageUtil;

	@Autowired
	private IUserService userService;
	
	@GetMapping("/quan-tri/chuyen-muc/danh-sach")
	public String showList(Model model, HttpServletRequest request) {
		if(SystemConstant.username == null) {
			return "redirect:/dang-nhap";
		}
		UserDTO user = userService.findOneByUserName(SystemConstant.username);
		if(user.getRoleCode().equals("USER")) {
			return "redirect:/trang-chu";
		}
		model.addAttribute("user", user);
		CategoryDTO listCategory = new CategoryDTO();
		listCategory.setListResult(categoryService.findAll());
		model.addAttribute("model",listCategory);
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			model.addAttribute("message", message.get("message"));
			model.addAttribute("alert", message.get("alert"));
		}
		return "admin/category/list";
	}
	
	@GetMapping("/quan-tri/chuyen-muc/chinh-sua")
	public String editNew(@RequestParam(value = "id", required = false) Long id, Model model, HttpServletRequest request) {
		if(SystemConstant.username == null) {
			return "redirect:/dang-nhap";
		}
		UserDTO user = userService.findOneByUserName(SystemConstant.username);
		if(user.getRoleCode().equals("USER")) {
			return "redirect:/trang-chu";
		}
		model.addAttribute("user", user);
		CategoryDTO categorys = new CategoryDTO();
		if (id != null) {
			categorys = categoryService.findById(id);
		}
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			model.addAttribute("message", message.get("message"));
			model.addAttribute("alert", message.get("alert"));
		}
		model.addAttribute("model", categorys);
		return "admin/category/edit";
	}
	
}
