package com.poly.store.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.poly.store.dao.orderDao;
import com.poly.store.dao.orderdetailDao;
import com.poly.store.entity.order;
import com.poly.store.entity.orderdetail;
import com.poly.store.service.orderService;


@Service
public class orderServiceImpl implements orderService{
	@Autowired
	orderDao dao;
	
	@Autowired
	orderdetailDao dao2;

	@Override
	public order create(JsonNode orderData) {
		ObjectMapper mapper = new ObjectMapper();

		order order = mapper.convertValue(orderData, order.class);
		dao.save(order);

		TypeReference<List<orderdetail>> type = new TypeReference<List<orderdetail>>() {};
		List<orderdetail> details = mapper.convertValue(orderData.get("orderdetails"), type).stream()
				.peek(d -> d.setOrder_id(order)).collect(Collectors.toList());
		dao2.saveAll(details);
		return order;
	}

	@Override
	public order findById(Long id) {
		return dao.findById(id).get();
	}

	@Override
	public List<order> findByUsername(String username) {
		// TODO Auto-generated method stub
		return dao.findByUsername(username);
	}
	
	

}
