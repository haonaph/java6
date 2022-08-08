package com.poly.store.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.store.dao.accountDao;
import com.poly.store.entity.account;
import com.poly.store.service.accountService;
@Service
public class accountServiceImpl implements accountService{
	@Autowired
	accountDao dao;

	@Override
	public account findById(String username) {
		// TODO Auto-generated method stub
		return dao.findById(username).get();
	}

}
