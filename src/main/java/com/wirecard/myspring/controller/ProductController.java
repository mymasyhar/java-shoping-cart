package com.wirecard.myspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.wirecard.myspring.repository.ProductRepository;

@Controller
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping("/product-list")
	public String showAllProducts(Model model) {
		model.addAttribute("products",productRepository.findAll());
		return "products";
	}
}
