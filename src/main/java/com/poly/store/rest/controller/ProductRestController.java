package com.poly.store.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poly.store.entity.product;
import com.poly.store.service.productService;

@CrossOrigin("**")
@RestController
@RequestMapping("/rest/products")
public class ProductRestController {
	@Autowired
	productService productService;
	
	@GetMapping()
	public List<product> getAll() {
	 return productService.findAll();	
	}

	@GetMapping("{id}")
	public product getOne(@PathVariable("id") Integer id) {
	 return productService.findById(id);	
	}
	
	@PostMapping
	public product create(@RequestBody product product) {
	 return productService.create(product);	
	}
	
	@PutMapping("{id}")
	public product update(@PathVariable("id") Integer id, @RequestBody product product) {
	 return productService.update(product);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Integer id) {
	  productService.delete(id);
	}
	
}
