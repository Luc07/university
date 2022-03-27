package com.facisa.arqi.product;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;
	
	public List<Product> getProducts() {
		return productRepository.findAll();
	}

	public Product createProduct(Product product) {
		return productRepository.save(product);
	}

	public Optional<Product> findById(int id) {
		return productRepository.findById(id);
	}
	
	public void deleteProduct(int id) {
		productRepository.deleteById(id);
	}
	
	public Product updateProduct(int id, Product product) {
		Product p = productRepository.getById(id);
		p.setName(product.getName());
		p.setValue(product.getValue());
		return productRepository.save(p);
	}
}
