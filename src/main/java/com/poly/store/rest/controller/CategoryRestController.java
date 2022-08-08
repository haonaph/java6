package com.poly.store.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poly.store.entity.category;
import com.poly.store.service.categoryService;

@CrossOrigin("**")
@RestController
@RequestMapping("/rest/categories")
public class CategoryRestController {
	@Autowired
	categoryService categoryService;
	
	@GetMapping()
	public List<category> getAll() {
	 return categoryService.findAll();	
	}

	
}
