package com.avvarga.productsandcategories.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.avvarga.productsandcategories.models.Category;
import com.avvarga.productsandcategories.models.Product;
import com.avvarga.productsandcategories.services.CategoryService;
import com.avvarga.productsandcategories.services.ProductService;

@Controller
public class PaCController {
	
	private final ProductService pServ;
	private final CategoryService cServ;
	
	public PaCController (ProductService pServ, CategoryService cServ) {
		this.pServ = pServ;
		this.cServ = cServ;
	}
	
	@RequestMapping ("/")
	public String index () {
		return "redirect:/products/new";
	}
	
	//Product
	@RequestMapping ("/products/new")
	public String newProduct (@ModelAttribute ("product") Product product) {
		
		return "newProduct.jsp";
	}
	
	@PostMapping ("/products/new")
	public String createProduct (@Valid @ModelAttribute ("product") Product product, BindingResult result) {
		if (result.hasErrors()) {
			return "newProduct.jsp";
		} else {
			pServ.addProduct(product);
			return "redirect:/categories/new";
		}
	}
	
	@RequestMapping ("/products/{id}")
	public String showProduct (@PathVariable ("id") Long id, Model m) {
		m.addAttribute("product", pServ.findById(id));
		m.addAttribute("categories", cServ.findAll());
		return "showProduct.jsp";
	}
	
	@PostMapping("/products/add/{id}")
	public String addCategory (@PathVariable ("id") Long id, @RequestParam("category") Long cId) {
		Product prod = pServ.findById(id);
		Category cat = cServ.findById(cId);
		cServ.updateCategories(prod,cat);
		return "redirect:/products/"+id;
	}

	
	//Category
	@RequestMapping ("/categories/new")
	public String newProduct (@ModelAttribute ("category") Category category) {
		
		return "newCategory.jsp";
	}
	
	@PostMapping ("/categories/new")
	public String createcategory (@Valid @ModelAttribute ("category") Category category, BindingResult result) {
		if (result.hasErrors()) {
			return "newCategory.jsp";
		} else {
			cServ.addCategory(category);
			return "redirect:/products/new";
		}
	}
	
	@RequestMapping ("/categories/{id}")
	public String showCategory (@PathVariable ("id") Long id, Model m) {
		m.addAttribute("category", cServ.findById(id));
		m.addAttribute("products", pServ.findAll());
		return "showCategory.jsp";
	}
	
	@PostMapping("/categories/add/{id}")
	public String addProduct (@PathVariable ("id") Long id, @RequestParam("product") Long pId) {
		Product prod = pServ.findById(pId);
		Category cat = cServ.findById(id);
		cServ.updateCategories(prod,cat);
		return "redirect:/categories/"+id;
	}
}
