package com.example.curse.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.curse.entities.Product;
import com.example.curse.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	
	public List<Product> ListaPorduto(){
		return productRepository.findAll();
	}
	public Product buscarPorId(Long id) {
		Optional<Product> obj = productRepository.findById(id);
		return obj.get();
	}
}
