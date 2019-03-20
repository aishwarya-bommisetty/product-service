package com.product.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.app.entities.ProductEntity;
/**
 * @author Aishwarya_Bommisetty
 *
 */
@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer>{
	public ProductEntity findById(int id);
}
