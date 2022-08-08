package com.poly.store.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecurityController {
	@RequestMapping("/security/login/form")
	public String form(Model model) {
		model.addAttribute("message","Vui lòng đăng nhập.");
		return "security/login";
	}
	
	@RequestMapping("/security/login/success")
	public String success(Model model) {
		model.addAttribute("message","Đăng nhập thành công.");
		return "security/login";
	}
	
	@RequestMapping("/security/login/error")
	public String error(Model model) {
		model.addAttribute("message","Sai thông tin đăng nhập.");
		return "security/login";
	}
	
	@RequestMapping("/security/unauthoriesd")
	public String unauthoriesd(Model model) {
		model.addAttribute("message","Không có quyền truy xuất.");
		return "security/login";
	}
	
	@RequestMapping("/security/logout/success")
	public String logoutsuccess(Model model) {
		model.addAttribute("message","Bạn đã đăng xuất.");
		return "security/login";
	}
    //@CrossOrigin("*")
}
