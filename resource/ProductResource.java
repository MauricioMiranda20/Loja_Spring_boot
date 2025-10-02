package com.example.curse.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.curse.entities.Product;
import com.example.curse.service.ProductService;

@RestController
@RequestMapping(value="/products")
public class ProductResource {

	@Autowired 
	private ProductService productService;

	@GetMapping
	public ResponseEntity<List<Product>> findAll(){
		List<Product> product = productService.ListaPorduto();
		return ResponseEntity.ok().body(product) ;
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id){
		Product obj = productService.buscarPorId(id);
		return ResponseEntity.ok().body(obj);
	}
}
