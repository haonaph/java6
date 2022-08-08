package com.poly.store.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.store.entity.product;
import com.poly.store.service.productService;

@Controller
public class ProductController {
	@Autowired
	productService productService;
	
	@RequestMapping("/product/list")
	public String list(Model model, @RequestParam("cid") Optional<String> cid) {
		if(cid.isPresent()) {
			List<product> list = productService.findByCategoryId(cid.get());
			model.addAttribute("items",list);
		}
		else {
			List<product> lst =productService.findAll();
			model.addAttribute("items",lst);
		}

		return "product/list";
	}


		@RequestMapping("/product/detail/{id}")
		public String detail(Model model, @PathVariable("id") Integer id) {
			product list = productService.findById(id);
			model.addAttribute("items",list);
			return "product/detail";
		}
}
