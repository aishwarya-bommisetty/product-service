package com.product.app.services;

import java.util.List;

import com.product.app.model.ProductModel;

/**
 * @author Aishwarya_Bommisetty
 *
 */

public interface ProductService {

	ProductModel findProductById(int id);

	void addProduct(ProductModel model);

	/**
	 * @param id
	 * @param name
	 */
	void updateName(int id, String name);

	/**
	 * @return
	 */
	List<ProductModel> findAll();

	/**
	 * @param id
	 */
	void deleteById(int id);
	
	/**
	 * @param name
	 * @return
	 */
	ProductModel findProductByName(String name);
}
