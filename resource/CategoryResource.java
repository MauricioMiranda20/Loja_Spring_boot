package com.example.curse.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.curse.entities.Category;
import com.example.curse.service.CategoryService;

@RestController
@RequestMapping(value="/categories")
public class CategoryResource {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping
	public List<Category> buscarTodos(){
		return categoryService.buscaTodos();		
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Category> buscarId(@PathVariable Long id){
		Category category = categoryService.buscarPorId(id);
		return ResponseEntity.ok().body(category);
	}
}
