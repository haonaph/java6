package com.poly.store.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.poly.store.entity.product;

public interface productDao extends JpaRepository<product, Integer>{
	@Query("select p from product p where p.category_id.id=?1")
	List<product> findByCategoryId(String cid);

}
