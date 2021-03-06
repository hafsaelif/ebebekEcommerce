package com.ebebek.controllers;

import com.ebebek.services.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@Autowired
	private ProductService productService;

	@GetMapping("/")
	public String getAllProducts(Model model) {

		model.addAttribute("products", productService.getAllProducts());
		return "home";

	}
	
	

}
