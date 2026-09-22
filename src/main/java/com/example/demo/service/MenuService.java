package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.Category;
import com.example.demo.model.Menu;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.MenuRepository;

@Service
public class MenuService {

	private final MenuRepository menuRepository;
	private final CategoryRepository categoryRepository;

	public MenuService(MenuRepository menuRepository, CategoryRepository categoryRepository) {
		this.menuRepository = menuRepository;
		this.categoryRepository = categoryRepository;
	}

	public Menu addMenu(Menu menu) {
		String categoryId = menu.getCategory().getCategoryId();
		Category category = categoryRepository.findById(categoryId)
				.orElseThrow(() -> new RuntimeException("Category not found"));
		menu.setCategory(category);
		return menuRepository.save(menu);
	}

	public List<Menu> getAllMenus() {
		return menuRepository.findAll();
	}

	public Optional<Menu> getMenuById(String id) {
		return menuRepository.findById(id);
	}
}

