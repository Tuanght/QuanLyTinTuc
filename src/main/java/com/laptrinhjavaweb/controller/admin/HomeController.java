package com.laptrinhjavaweb.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.service.IUserService;

@Controller(value = "homeControllerOfAdmin")
public class HomeController {

	@Autowired
	private IUserService userService;
	
	@GetMapping("/quan-tri/trang-chu")
	public String homePage(Model model) {
		if(SystemConstant.username == null) {
			return "redirect:/dang-nhap";
		}
		UserDTO user = userService.findOneByUserName(SystemConstant.username);
		if(user.getRoleCode().equals("USER")) {
			return "redirect:/trang-chu";
		}
		model.addAttribute("user", user);
		return "admin/home";
	}
}
