package com.product.app.services;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.app.entities.ProductEntity;
import com.product.app.model.ProductModel;
import com.product.app.repository.ProductRepository;

/**
 * @author Aishwarya_Bommisetty
 *
 */
@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	ProductRepository productRepository;

	DozerBeanMapper mapper = new DozerBeanMapper();

	@Override
	public ProductModel findProductById(int id) {
		ProductEntity entity = productRepository.findById(id);
		return mapper.map(entity, ProductModel.class);
	}

	@Override
	public void addProduct(ProductModel model) {

		ProductEntity entity= mapper.map(model,ProductEntity.class);
		productRepository.save(entity);
		productRepository.flush();

	}

	@Override
	public void updateName(int id, String name) {
		ProductEntity entity = productRepository.findById(id);
		entity.setName(name);
		productRepository.save(entity);
	}


	@Override
	public List<ProductModel> findAll() {
		List<ProductEntity> entities = productRepository.findAll();
		List<ProductModel> models = new ArrayList<>();
		for(ProductEntity entity : entities) {
			models.add(mapper.map(entity, ProductModel.class));
		}
		return models;
	}

	@Override
	public void deleteById(int id) {
		productRepository.deleteById(id);
		
	}

	@Override
	public ProductModel findProductByName(String name) {
		ProductEntity entity = productRepository.findFirstByName(name);
		return mapper.map(entity, ProductModel.class);
	}
	
}
