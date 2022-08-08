package com.poly.store.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.store.dao.categoryDao;
import com.poly.store.entity.category;
import com.poly.store.service.categoryService;

@Service
public class categoryServiceImpl implements categoryService{
	@Autowired
	categoryDao cDao;

	@Override
	public List<category> findAll() {
		// TODO Auto-generated method stub
		return cDao.findAll();
	}

}
