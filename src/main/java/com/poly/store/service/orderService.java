package com.poly.store.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.poly.store.entity.order;


public interface orderService {

	order create(JsonNode orderData);

	order findById(Long id);

	List<order> findByUsername(String username);

}
