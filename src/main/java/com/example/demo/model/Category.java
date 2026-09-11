package com.example.demo.model;

import java.util.*;

public class Category {
	private String categoryId;
	private String categoryName;
	private List<Menu> menuList = new ArrayList<>();

//	public Category(String categoryId, String categoryName, List<Menu> menuList) {
//		super();
//		this.categoryId = categoryId;
//		this.categoryName = categoryName;
//		this.menuList = menuList;
//	}

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void addMenu(Menu menu) {
		this.menuList.add(menu);
	}

	public List<Menu> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<Menu> menuList) {
		this.menuList = menuList;
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

}
