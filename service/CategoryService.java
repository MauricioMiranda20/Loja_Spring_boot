package com.example.curse.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.curse.entities.Category;
import com.example.curse.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Category> buscaTodos(){
		return categoryRepository.findAll();
	}
	public Category buscarPorId(Long id){
		Optional<Category> obj = categoryRepository.findById(id);
		return obj.get();
	}
	
}
