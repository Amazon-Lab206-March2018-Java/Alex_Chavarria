package com.avvarga.productsandcategories.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.avvarga.productsandcategories.models.Category;
import com.avvarga.productsandcategories.models.Product;
import com.avvarga.productsandcategories.repositories.CategoryRepository;

@Service
public class CategoryService {

	private CategoryRepository cRepo;
	
	public CategoryService (CategoryRepository cRepo) {
		this.cRepo = cRepo;
	}
	
	public List<Category> findAll(){
		return cRepo.findAll();
	}

	public void addCategory(@Valid Category category) {
		cRepo.save(category);
	}
	public Category findById(Long id) {
		Optional <Category> oCategory = cRepo.findById(id);
		return oCategory.get();
	}

	public void updateCategories(Product prod, Category cat) {
		cat.updateProduct(prod);
		cRepo.save(cat);
	}
}
