package com.sl.ms.inventorymanagement;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface ProductRepo extends JpaRepository<Product, Integer> {
	
	@Query("SELECT distinct new com.sl.ms.inventorymanagement.UniquePrd(productid, name) FROM Product")
	public List<UniquePrd> findDistinctproduct();

	@Transactional
	@Modifying
	@Query("UPDATE Product SET quantity = 0 where productid=:product_id")
	void deletePrd(@Param("product_id") Integer product_id);
	
	}

