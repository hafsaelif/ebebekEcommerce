package com.ebebek.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ebebek.models.Item;
import com.ebebek.models.Product;
import com.ebebek.services.ProductService;

@Controller
public class CartController {

	@Autowired
	private ProductService productService;

	@GetMapping("/cart")
	public String getAllProducts(Model model) {

		model.addAttribute("cart", productService.getAllProducts());
		return "cart";

	}

	@RequestMapping(value = "/cart/{productId}", method = RequestMethod.GET)
	public String buy(@PathVariable("productId") String id, ModelMap modelMap, HttpSession session) {

		modelMap.put("products", productService.getAllProducts());
		if (session.getAttribute("cart") == null) {
			List<Item> cart = new ArrayList<Item>();
			cart.add(new Item(productService.getProductById(id), 1));			
			session.setAttribute("cart", cart);	

		} else {
			List<Item> cart = (List<Item>)session.getAttribute("cart");
			int index = isExists(id, cart);
			if (index == -1) {
				cart.add(new Item(productService.getProductById(id), 1));
			} else {
				int quantity = cart.get(index).getQuantity() + 1;
				cart.get(index).setQuantity(quantity);
			}
			session.setAttribute("cart", cart);
			
		}

		return "cart";

	}
	
	@RequestMapping(value = "/cart/decrease/{productId}", method = RequestMethod.GET)
	public String decrease(@PathVariable("productId") String id, ModelMap modelMap, HttpSession session) {
		modelMap.put("products", productService.getAllProducts());
		if (session.getAttribute("cart") == null) {
			return "redirect:/home";

		} else {
			List<Item> cart = (List<Item>)session.getAttribute("cart");
			int index = isExists(id, cart);
			if(cart.get(index).getQuantity() == 1) {
				cart.remove(index);
				if (session.getAttribute("cart") == null) {
					return "home";
				}
			}
			else {
				int quantity = cart.get(index).getQuantity() -1;
				cart.get(index).setQuantity(quantity);
				
			}			
			session.setAttribute("cart", cart);
		}
		
		
		return "cart";
	}
	

	private int isExists(String id, List<Item> cart) {
		for (int i = 0; i < cart.size(); i++) {	
			Product currentProduct = cart.get(i).getProduct();
			if (currentProduct.getName() == productService.getProductById(id).getName()) {
				return i;
			}
		}
		return -1;

	}

}
