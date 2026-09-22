package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Menu;
import com.example.demo.service.MenuService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class MenuController {

	private final MenuService menuService;

	public MenuController(MenuService menuService) {
		this.menuService = menuService;
	}

	@PostMapping("/menu")
	public ResponseEntity<Menu> addMenu(@RequestBody Menu menu) {
		Menu newMenu = menuService.addMenu(menu);
		return ResponseEntity.status(HttpStatus.CREATED).body(newMenu);
	}

	@GetMapping("/menus")
	public ResponseEntity<List<Menu>> getAllMenus() {
		return ResponseEntity.ok(menuService.getAllMenus());
	}

	@GetMapping("/menus/{id}")
	public ResponseEntity<Menu> getMenuById(@PathVariable("id") String id) {
		return menuService.getMenuById(id)
				.map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());
	}
}

