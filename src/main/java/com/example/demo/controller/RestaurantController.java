package com.example.demo.controller;

import java.util.*;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Category;
import com.example.demo.model.Menu;
//import com.example.demo.model.Product;

@RestController
public class RestaurantController {
	
	private List<Category> categoyTest = new ArrayList<>();
//	private List<Menu> menus = new ArrayList<>();
	
	
	public RestaurantController(){
	Category category1 = new Category("C001", "อาหารจานเดียว");
	category1.addMenu(new Menu("M001", "ข้าวมันไก่", 50.0));
	category1.addMenu(new Menu("M002", "ข้าวหมูแดง", 50.0));
	category1.addMenu(new Menu("M003", "ข้าวขาหมู", 60.0));
	category1.addMenu(new Menu("M004", "ข้าวหน้าเป็ด", 70.0));
	
	
	Category category2 = new Category("C002", "อาหารทานเล่น");
	category2.addMenu(new Menu("M005", "ไก่ทอด", 60.0));
	category2.addMenu(new Menu("M006", "ปอเปี๊ยะทอด", 50.0));
	category2.addMenu(new Menu("M007", "เฟรนฟราย", 40.0));
	category2.addMenu(new Menu("M008", "เกี๊ยวซ่า", 50.0));
	
	Category category3 = new Category("C003", "อาหารจานหลัก");
	category3.addMenu(new Menu("M009", "สปาเก็ตตี้", 80.0));
	category3.addMenu(new Menu("M010", "สเต็ก", 150.0));
	category3.addMenu(new Menu("M011", "ข้าวผัด", 60.0));
	category3.addMenu(new Menu("M012", "ผัดไทย", 70.0));
	
	categoyTest.add(category1);
	categoyTest.add(category2);	
	categoyTest.add(category3);
	
	}
	
	
    @GetMapping("/category") 
    public List<Category>getCategory() {
		return categoyTest;
	}
    
    @GetMapping("/category/{id}")
	public Category getCategory(@PathVariable("id") String id) {
		for (Category category : categoyTest) {
			if (category.getCategoryId().equalsIgnoreCase(id)) {
				return category;
			}
		}
		return null;
	}
	
    @GetMapping("/menu/{id}")
    public Menu getMenu(@PathVariable("id") String id) {
		for (Category category : categoyTest) {
			for (Menu menu : category.getMenuList()) {
				if (menu.getMenuId().equalsIgnoreCase(id)) {
					return menu;
				}
			}
		}
		return null;
	}
    
//    @GetMapping("/products/{id}")
//    public Product getProduct(@PathVariable("id") String id) {
//        for (Product product : products) {
//            if (product.getProductid().equalsIgnoreCase(id)) {
//                return product;
//            }
//        }
//        return null;
//    }
//	
	
}

