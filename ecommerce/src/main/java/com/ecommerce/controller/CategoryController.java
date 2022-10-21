package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.model.Category;
import com.ecommerce.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
	@Autowired
	CategoryService categoryService;
	
	@PostMapping("/addcategory")
	public ResponseEntity<Category> createCategory(@RequestBody Category category){
		Category newCategory =  categoryService.createCategory(category);
		
		return new ResponseEntity<Category>(newCategory,HttpStatus.CREATED);
	}
	
	@GetMapping("/getcategory")
	public ResponseEntity<List<Category>> getCategory(){
		List<Category> allCategories =  categoryService.getAllCategories();
		
		return new ResponseEntity<List<Category>>(allCategories,HttpStatus.FOUND);
	}
}
