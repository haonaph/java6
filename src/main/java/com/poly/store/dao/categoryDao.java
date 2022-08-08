package com.poly.store.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.poly.store.entity.category;

public interface categoryDao extends JpaRepository<category,Integer>{
	@Query("SELECT c FROM category c WHERE id=:id")
	public category findById(@Param("id") String id);
}
