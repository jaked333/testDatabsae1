package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.model.Category;
import com.example.demo.model.Menu;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.MenuRepository;

@Component
public class DataInitializer implements CommandLineRunner {

	private final CategoryRepository categoryRepository;
	private final MenuRepository menuRepository;

	public DataInitializer(CategoryRepository categoryRepository, MenuRepository menuRepository) {
		this.categoryRepository = categoryRepository;
		this.menuRepository = menuRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		if (categoryRepository.count() == 0) {
			Category cat1 = new Category("C001", "อาหารจานเดียว");
			Category cat2 = new Category("C002", "อาหารทานเล่น");
			Category cat3 = new Category("C003", "อาหารจานหลัก");

			categoryRepository.save(cat1);
			categoryRepository.save(cat2);
			categoryRepository.save(cat3);

			menuRepository.save(new Menu("M001", "ข้าวมันไก่", 50.0, cat1));
			menuRepository.save(new Menu("M002", "ข้าวหมูแดง", 50.0, cat1));
			menuRepository.save(new Menu("M003", "ข้าวขาหมู", 60.0, cat1));
			menuRepository.save(new Menu("M004", "ข้าวหน้าเป็ด", 70.0, cat1));

			menuRepository.save(new Menu("M005", "ไก่ทอด", 60.0, cat2));
			menuRepository.save(new Menu("M006", "ปอเปี๊ยะทอด", 50.0, cat2));
			menuRepository.save(new Menu("M007", "เฟรนฟราย", 40.0, cat2));
			menuRepository.save(new Menu("M008", "เกี๊ยวซ่า", 50.0, cat2));

			menuRepository.save(new Menu("M009", "สปาเก็ตตี้", 80.0, cat3));
			menuRepository.save(new Menu("M010", "สเต็ก", 150.0, cat3));
			menuRepository.save(new Menu("M011", "ข้าวผัด", 60.0, cat3));
			menuRepository.save(new Menu("M012", "ผัดไทย", 70.0, cat3));

			System.out.println("=================================================");
			System.out.println(">>> Sample data auto-seeded into MySQL successfully! <<<");
			System.out.println("=================================================");
		}
	}
}

