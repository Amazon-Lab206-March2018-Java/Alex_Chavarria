package com.avvarga.productsandcategories.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.avvarga.productsandcategories.models.Category;
import com.avvarga.productsandcategories.models.Product;
import com.avvarga.productsandcategories.repositories.ProductRepository;

@Service
public class ProductService {
	
	private ProductRepository pRepo;
	
	public ProductService (ProductRepository pRepo) {
		this.pRepo = pRepo;
	}
	
	public List<Product> findAll(){
		return pRepo.findAll();
	}

	public void addProduct(@Valid Product product) {
		pRepo.save(product);
	}

	public Product findById(Long id) {
		Optional <Product> oProduct = pRepo.findById(id);
		return oProduct.get();
	}

	public void updateProducts (Product prod, Category cat) {
		prod.updateCategory(cat);
		pRepo.save(prod);
	}

}
