package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "menu")
public class Menu {

	@Id
	@Column(name = "menu_id")
	private String menuId;

	@Column(name = "menu_name")
	private String menuName;

	@Column(name = "price")
	private double price;

	@JsonIgnoreProperties({"menus", "menuList"})
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	public Menu() {
		super();
	}

	public Menu(String menuId, String menuName, double price) {
		super();
		this.menuId = menuId;
		this.menuName = menuName;
		this.price = price;
	}

	public Menu(String menuId, String menuName, double price, Category category) {
		super();
		this.menuId = menuId;
		this.menuName = menuName;
		this.price = price;
		this.category = category;
	}

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
}
