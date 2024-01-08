package com.laptrinhjavaweb.controller.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.dto.CommentDTO;
import com.laptrinhjavaweb.dto.NewDTO;
import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.service.ICategoryService;
import com.laptrinhjavaweb.service.ICommentService;
import com.laptrinhjavaweb.service.INewService;
import com.laptrinhjavaweb.service.IUserService;

@Controller(value = "homeControllerOfWeb")
public class HomeController {

	@Autowired
	private INewService newService;

	@Autowired
	private ICategoryService categoryService;

	@Autowired
	private IUserService userService;
	
	@Autowired
	private ICommentService commentService;

	@GetMapping("/trang-chu")
	public String homePage(@RequestParam(value = "id", required = false) Long id, Model model,
			HttpServletRequest request) {
		NewDTO listnew = new NewDTO();
		UserDTO user = new UserDTO();
		if (SystemConstant.username == null) {
			user = null;
		} else {
			user = userService.findOneByUserName(SystemConstant.username);
		}

		if (id == null) {
			listnew.setListResult(newService.findAll());
		} else {
			listnew.setListResult(newService.findAllByCategoryId(id));
		}
		SystemConstant.title = null;
		SystemConstant.id = null;
		model.addAttribute("categories", categoryService.findAll());
		model.addAttribute("model", listnew);
		model.addAttribute("user", user);
		return "web/home";
	}

	@GetMapping("/tin-tuc")
	public String newDetail(@RequestParam(value = "id") Long id, Model model) {
		NewDTO news = new NewDTO();
		UserDTO user = new UserDTO();
		if (SystemConstant.username == null) {
			user = null;
		} else {
			user = userService.findOneByUserName(SystemConstant.username);
		}
		model.addAttribute("user", user);
		news = newService.findById(id);
		SystemConstant.id = id.toString();
		SystemConstant.title = news.getTitle();
		model.addAttribute("categories", categoryService.findAll());
		model.addAttribute("comments", commentService.findAllByNewId(id));
		model.addAttribute("model", news);
		return "/web/new/news";
	}
	
	@PostMapping("/gui-tin")
	public String giveComment(@RequestParam("content") String content, Model model) {
		CommentDTO comment = new CommentDTO();
		comment.setContent(content);
		comment.setTitle(SystemConstant.title);
		comment.setUserName(SystemConstant.username);
		commentService.save(comment);
		return "redirect:/tin-tuc?id="+SystemConstant.id;
	}
	
	@GetMapping("/dang-nhap")
	public String showLogin() {
		return "login";
	}

	@PostMapping("/kiem-tra")
	public String checkLogin(@RequestParam("username") String username, @RequestParam("password") String password,
			Model model) {
		UserDTO user = userService.findOneByUserName(username);
		if (user.getPassword().equals(password)) {
			SystemConstant.username = username;
			model.addAttribute("user", user);
			if (user.getRoleCode().equals("USER")) {
				return "redirect:/trang-chu";
			}
			return "redirect:/quan-tri/trang-chu";
		}
		model.addAttribute("ERROR", "Username and password not exist");
		return "login";
	}

	@GetMapping("/thoat")
	public String logout() {
		SystemConstant.username = null;
		return "login";
	}

	@GetMapping("/dang-ky")
	public String showRegister() {
		return "register";
	}

	@PostMapping("/dang-ky-thanh-cong")
	public String checkRegister(@RequestParam("username") String username, @RequestParam("fullname") String fullname,
			@RequestParam("password") String password, Model model) {
		UserDTO user = new UserDTO();
		user.setUserName(username);
		user.setFullName(fullname);
		user.setPassword(password);
		user.setStatus(1);
		user.setRoleCode("USER");
		userService.save(user);
		return "redirect:/dang-nhap";
	}

}
