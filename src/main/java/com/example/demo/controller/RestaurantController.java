package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Category;
import com.example.demo.model.Menu;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.MenuRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class RestaurantController {

	private final CategoryRepository categoryRepository;
	private final MenuRepository menuRepository;

	public RestaurantController(CategoryRepository categoryRepository, MenuRepository menuRepository) {
		this.categoryRepository = categoryRepository;
		this.menuRepository = menuRepository;
	}

	@GetMapping("/category")
	public List<Category> getCategory() {
		return categoryRepository.findAll();
	}

	@GetMapping("/category/{id}")
	public Category getCategory(@PathVariable("id") String id) {
		return categoryRepository.findById(id).orElse(null);
	}

	@GetMapping("/menu/{id}")
	public Menu getMenu(@PathVariable("id") String id) {
		return menuRepository.findById(id).orElse(null);
	}
}
