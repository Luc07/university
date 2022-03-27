package com.facisa.arqi.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/product")
	public ResponseEntity<List<Product>> getProducts() {
		return ResponseEntity.status(HttpStatus.OK).body(productService.getProducts());
	}
	
	@PostMapping("/product")
	public ResponseEntity<Product> createProduct(@RequestBody Product product){
		return ResponseEntity.status(HttpStatus.CREATED).body(productService.createProduct(product));
	}
	
	@DeleteMapping("/product/{id}")
	public ResponseEntity<Object> deleteProduct(@PathVariable int id) {
		productService.deleteProduct(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Product Deleted!");
	}
	
	@PutMapping("/product/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable int id, @RequestBody Product product){
		return ResponseEntity.status(HttpStatus.OK).body(productService.updateProduct(id, product));
	}
}
