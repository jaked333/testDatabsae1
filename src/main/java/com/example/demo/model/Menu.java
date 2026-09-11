package com.example.demo.model;

public class Menu {

	private String menuId;
	private String menuName;
	private Double price;

	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Menu(String menuId, String menuName, Double price) {
		super();
		this.menuId = menuId;
		this.menuName = menuName;
		this.price = price;
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}
