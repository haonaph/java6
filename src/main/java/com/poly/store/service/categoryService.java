package com.poly.store.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.poly.store.entity.category;

@Service
public interface categoryService {

	List<category> findAll();



}
