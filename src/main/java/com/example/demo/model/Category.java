package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "category")
public class Category {

	@Id
	@Column(name = "category_id")
	private String categoryId;

	@Column(name = "category_name")
	private String categoryName;

	@JsonIgnoreProperties("category")
	@JsonIgnore
	@OneToMany(mappedBy = "category")
	private List<Menu> menus = new ArrayList<>();

	public Category() {
		super();
	}

	public Category(String categoryId, String categoryName) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@JsonIgnore
	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

	// Backwards compatibility for existing code using getMenuList
	@JsonIgnore
	public List<Menu> getMenuList() {
		return menus;
	}

	public void setMenuList(List<Menu> menuList) {
		this.menus = menuList;
	}

	public void addMenu(Menu menu) {
		this.menus.add(menu);
		menu.setCategory(this);
	}
}
