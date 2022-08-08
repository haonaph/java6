package com.poly.store.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.store.dao.productDao;
import com.poly.store.entity.product;
import com.poly.store.service.productService;

@Service
public class productServiceImpl implements productService{
	@Autowired
	productDao pdao;

	@Override
	public List<product> findAll() {
		
		return pdao.findAll();
	}

	@Override
	public product findById(Integer id) {
		// TODO Auto-generated method stub
		return pdao.findById(id).get();
	}

	@Override
	public List<product> findByCategoryId(String cid) {
		// TODO Auto-generated method stub
		return pdao.findByCategoryId(cid);
	}

	@Override
	public product create(product product) {
		return pdao.save(product);
	}

	@Override
	public product update(product product) {
		
		return pdao.save(product);
	}

	@Override
	public void delete(Integer id) {
		
		pdao.deleteById(id);;
	}


}
