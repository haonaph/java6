package com.poly.store.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.poly.store.entity.order;

public interface orderDao extends JpaRepository<order, Long>{
	
	@Query("SELECT o FROM order o WHERE o.account.username=?1")
	List<order> findByUsername(String username);

}
