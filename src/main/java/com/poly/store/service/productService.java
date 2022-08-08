package com.poly.store.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.poly.store.entity.product;
@Service
public interface productService {

	List<product> findAll();

	product findById(Integer id);

	List<product> findByCategoryId(String cid);

	product create(product product);

	product update(product product);

	void delete(Integer id);



}
