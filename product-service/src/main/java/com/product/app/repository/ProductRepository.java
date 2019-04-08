package com.product.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.product.app.entities.ProductEntity;
/**
 * @author Aishwarya_Bommisetty
 *
 */
@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer>{
	public ProductEntity findById(int id);

	//@Query("select p from ProductEntity p where p.name = :name LIMIT 1")
	public ProductEntity findFirstByName(@Param("name") String name);
}
