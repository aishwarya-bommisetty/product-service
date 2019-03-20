package com.product.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.app.model.ProductModel;
import com.product.app.services.ProductService;

@RestController
@RequestMapping("/Product")
public class ProductServiceController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("getAll")
	ResponseEntity<List<ProductModel>> getAll() {
		return ResponseEntity.ok().body(productService.findAll());
	}
	@GetMapping("get/{id}")
	ResponseEntity<ProductModel> getProductById(@PathVariable int id) {
		return ResponseEntity.ok().body(productService.findProductById(id));
	}
	
	@PostMapping("add")
	void addProduct(@RequestBody ProductModel model) {
		productService.addProduct(model);
	}
	
	@PutMapping("{id}/{name}/updateName")
	void modifyProduct( @PathVariable("id") int id, @PathVariable("name") String name) {
		productService.updateName(id, name);
	}
	
	@DeleteMapping("delete/{id}")
	void deleteProductById(@PathVariable("id") int id) {
		productService.deleteById(id);
	}
	
}
